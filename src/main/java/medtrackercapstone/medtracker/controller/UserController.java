package medtrackercapstone.medtracker.controller;


import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.*;
import medtrackercapstone.medtracker.database.entity.*;
import medtrackercapstone.medtracker.formbean.RegisterFormBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private LogDAO logDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private UserMedDAO userMedDao;

    @Autowired
    private PasswordEncoder passwordEncoder;



    // Method to set page view for registration page
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        // Sets the form
        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }


    // Method to register new user
    @RequestMapping(value = "/user/registerSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();


//        Checks for errors/missing fields in user input and displays the errors back to the user
        if (bindingResult.hasErrors() ) {
            for ( ObjectError error : bindingResult.getAllErrors()) {
                log.info( ((FieldError) error).getField()  + " " + error.getDefaultMessage() );
            }

            response.addObject("form", form);

            response.addObject("bindingResult", bindingResult);

            response.setViewName("/user/register");
            return response;
        }

        // Checks to see if user is already in the database
        User user = userDao.findByEmail(form.getEmail());

        // Create new user if not already in the database and sets values to those in the form
        if ( user == null ) {
            user = new User();
        }

        String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);
        user.setEmail(form.getEmail());
        user.setName(form.getName());

        userDao.save(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setUserRole("USER");

        userRoleDao.save(userRole);

        log.info(form.toString());

        // Redirects user to their dashboard page upon registration
        response.setViewName("redirect:/user/userDashboard/" + user.getId());

        return response;
    }


    // Method to redirect user to their dashboard when they click on MyDashboard in the nav bar
    @RequestMapping(value = "/user/userDashboard", method = RequestMethod.GET )
    public ModelAndView userDashboard() {
        ModelAndView response = new ModelAndView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        // If user is known then a new array of meds is created and added to the model
        if(!StringUtils.equals("anonymousUser", currentPrincipalName)){
            User user = userDao.findByEmail(currentPrincipalName);
            response.addObject("user", user);
            response.setViewName("redirect:/user/userDashboard/" + user.getId());
        }

        return response;
    }


    // Method to populate meds on userDashboard page
    @RequestMapping(value = "/user/userDashboard/{userId}", method = RequestMethod.GET )
    public ModelAndView setUserDashboard(@PathVariable("userId") Integer userId) {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/userDashboard");

        // Creates a new array of all medications and logs
        List<UserMed> meds = new ArrayList<>();
        List<Log> logs = new ArrayList<>();

        // Queries the database for all medications and logs
        meds = userMedDao.findByUserId(userId);
        logs = logDao.findByUserId(userId);

        // Reverses the log list to print most recent first
        Collections.reverse(logs);

        // Adds med list to model
        response.addObject("meds", meds);
        response.addObject("logs", logs);

        return response;

    }


    }


