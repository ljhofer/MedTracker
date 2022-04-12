package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.MedicationDAO;
import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.dao.UserMedDAO;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.database.entity.UserMed;
import medtrackercapstone.medtracker.formbean.AddUserMedFormBean;
import medtrackercapstone.medtracker.formbean.UpdateUserMedFormBean;
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
public class UserMedController {

    @Autowired
    private UserMedDAO userMedDao;

    @Autowired
    private MedicationDAO medicationDao;

    @Autowired
    private UserDAO userDao;


    // Method to set view on addUserMed page
    @RequestMapping(value = "/userMed/addUserMed", method = RequestMethod.GET )
    public ModelAndView addUserMed() {
        ModelAndView response = new ModelAndView();
        response.setViewName("userMed/addUserMed");

        AddUserMedFormBean form = new AddUserMedFormBean();
        response.addObject("form", form);

//        // Creates a new array of all medications
        List<Medication> meds = new ArrayList<>();
//
//        // Queries the database for all medications
        meds = medicationDao.findAll();
//
//        // Adds med list to model
        response.addObject("meds", meds);

        return response;

    }


    // Method to add a UserMed record based on the information populated in the addUserMed form
    @RequestMapping(value = "/userMed/addUserMedSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView addUserMedSubmit(@Valid AddUserMedFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

//        if (bindingResult.hasErrors() ) {
//
//            List<String> errorMessages = new ArrayList<>();
//            for ( ObjectError error : bindingResult.getAllErrors()) {
//                errorMessages.add(error.getDefaultMessage());
//                log.info( ((FieldError) error).getField()  + " " + error.getDefaultMessage() );
//            }
//
//            response.addObject("form", form);
//
//            response.addObject("bindingResult", bindingResult);
//
//            // because there is one or more error we do not want to process the logic below
//            // that will creat a new user in the database we want to show the same model that we are already on
//            response.setViewName("/medication/userMedSubmit");
//            return response;
//        }

        // Creates new userMed record and sets values equal to those in the form
        UserMed userMed = new UserMed();
//
        userMed.setFrequency(form.getFrequency());
        userMed.setDosage(form.getDosage());
        userMed.setMedication(medicationDao.getById(form.getMedId()));

        // TODO make this populate with real user id
        userMed.setUser(userDao.getById(1));

        userMedDao.save(userMed);

        // TODO: send to individual dashboard page and add proper commenting
        response.setViewName("redirect:/user/userDashboard");

        return response;
    }


    // Method to set view on updateUserMed page
    // Add a param here to get UserMed by Id from the previous page
    @RequestMapping(value = "/userMed/updateUserMed", method = RequestMethod.GET )
    public ModelAndView updateUserMed() {
        ModelAndView response = new ModelAndView();
        response.setViewName("userMed/updateUserMed");

        UpdateUserMedFormBean form = new UpdateUserMedFormBean();
        response.addObject("form", form);

//        // Creates a new array of all medications
//        List<UserMed> meds = new ArrayList<>();
        UserMed userMed = new UserMed();
//
//        // Queries the database for all medications
        // TODO: Make this grab the actual UserMed id and not hard coding it
        userMed = userMedDao.getById(4);

        log.info(userMed.toString());
//
//        // Adds med list to model
        response.addObject("userMed", userMed);

        return response;

    }




























}
