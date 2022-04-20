package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.LogDAO;
import medtrackercapstone.medtracker.database.dao.MedicationDAO;
import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.dao.UserMedDAO;
import medtrackercapstone.medtracker.database.entity.Log;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.database.entity.User;
import medtrackercapstone.medtracker.database.entity.UserMed;
import medtrackercapstone.medtracker.formbean.AddUserLogFormBean;
import medtrackercapstone.medtracker.formbean.AddUserMedFormBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class LogController {

    @Autowired
    private LogDAO logDao;

    @Autowired
    private MedicationDAO medicationDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserMedDAO userMedDao;


    // Method to set view on addUserLog page
    @RequestMapping(value = "/log/addUserLog", method = RequestMethod.GET )
    public ModelAndView addUserLog() {
        ModelAndView response = new ModelAndView();
        response.setViewName("/log/addUserLog");

        AddUserLogFormBean form = new AddUserLogFormBean();
        response.addObject("form", form);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        // If user is known then a new array of current user's meds is created and added to the form
        if(!StringUtils.equals("anonymousUser", currentPrincipalName)){
            User user = userDao.findByEmail(currentPrincipalName);
            List<UserMed> meds = userMedDao.findByIdAndActive(user.getId());
            response.addObject("meds", meds);
        }

        return response;

    }


    // Method to add a UserMed record based on the information populated in the addUserMedFormBean
    @RequestMapping(value = "/log/addUserLogSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView addUserLogSubmit(@Valid AddUserLogFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        log.info(form.toString());

//        Checks for errors/missing fields in user input and displays the errors back to the user
        if (bindingResult.hasErrors() ) {
            for ( ObjectError error : bindingResult.getAllErrors()) {
                log.info( ((FieldError) error).getField()  + " " + error.getDefaultMessage() );
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            // Reloads the medication dropdown for current user
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();

            if(!StringUtils.equals("anonymousUser", currentPrincipalName)){
                User user = userDao.findByEmail(currentPrincipalName);
                List<UserMed> meds = userMedDao.findByUserId(user.getId());
                response.addObject("meds", meds);

                response.setViewName("log/addUserLog");
                return response;
            }

        }

        // Creates new userLog record and sets values equal to those in the form
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        if(!StringUtils.equals("anonymousUser", currentPrincipalName)){
            User user = userDao.findByEmail(currentPrincipalName);

            Log userLog = new Log();

            userLog.setMedication(medicationDao.getById(form.getMedId()));
            userLog.setSideEffects(form.getSideEffects());
            userLog.setCreatedOn(new Date());

            userLog.setUser(user);

            logDao.save(userLog);

            // Redirects user to their dashboard page
            response.setViewName("redirect:/user/userDashboard/" + user.getId());

        }

        return response;
    }


}
