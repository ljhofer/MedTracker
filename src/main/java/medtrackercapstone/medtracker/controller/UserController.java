package medtrackercapstone.medtracker.controller;


import lombok.extern.slf4j.Slf4j;
//import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.dao.MedicationDAO;
import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.database.entity.User;
import medtrackercapstone.medtracker.formbean.RegisterFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private MedicationDAO medicationDao;

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
    public ModelAndView registerSubmit(@Valid RegisterFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

//        TODO: Decide about desplaying these error or figure out how to use Bootstrap validation
//        if (bindingResult.hasErrors() ) {
//            for ( ObjectError error : bindingResult.getAllErrors()) {
//                log.info( ((FieldError) error).getField()  + " " + error.getDefaultMessage() );
//            }
//
//            // because there is one or more error we do not want to process the logic below
//            // that will creat a new user in the database we want to show the same model that we are already on
//            response.setViewName("/user/register");
//            return response;
//        }

        // Checks to see if user is already in the database
        User user = userDao.findById(form.getId());

        // Create new user if not already in the database and sets values to those in the form
        if ( user == null ) {
            user = new User();
        }

        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setPassword(form.getPassword());

        userDao.save(user);

        log.info(form.toString());

        // TODO: Decide what to do here and add approppriate commenting
       // R
        response.setViewName("redirect:/user/userDashboard");

        return response;
    }

    // Method to populate meds on userDashboard page
    @RequestMapping(value = "/user/userDashboard", method = RequestMethod.GET )
    public ModelAndView findAll() {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/userDashboard");

        // Creates a new array of all medications
        List<Medication> meds = new ArrayList<>();

        // Queries the database for all medications
        meds = medicationDao.findAll();

        // Adds med list to model
        response.addObject("meds", meds);

        return response;

    }


    // Method to return medication data based on medication name

//    @RequestMapping(value = "/user/dashboard", method = RequestMethod.GET )
//    public ModelAndView findByName(@RequestParam (required = false) String name) {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("user/dashboard");
//
//        // Creates a new array of all medications
//        List<Medication> meds = new ArrayList<>();
//        name = "Aspirin";
//
//        // Queries the database for all medications
//        meds = medicationDao.findByName(name);
//
//        // Adds med list to model
//        response.addObject("meds", meds);
//
//        return response;
//
//    }















}
