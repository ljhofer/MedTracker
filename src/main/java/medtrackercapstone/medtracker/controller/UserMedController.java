package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.UserMedDAO;
import medtrackercapstone.medtracker.database.entity.UserMed;
import medtrackercapstone.medtracker.formbean.AddUserMedFormBean;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserMedController {

    @Autowired
    private UserMedDAO userMedDao;

    // Method to add a UserMed record based on the information populated in the addUserMedFormBean
    @RequestMapping(value = "/medication/userMedSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView userMedSubmit(@Valid AddUserMedFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        log.info(form.toString());

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

        // Checks to see if userMed is already in the database
        UserMed userMed = userMedDao.findById(form.getId());

        // Creates new userMed record if not already in database and sets values equal to those in the form
        if ( form.getId() == null ) {
            userMed = new UserMed();
        }

        userMed.setId(form.getId());
        userMed.setFrequency(form.getFrequency());
        userMed.setDosage(form.getDosage());
//        userMed.setMed_id(form.getMed_id();

        userMedDao.save(userMed);

        log.info(form.toString());

        // TODO: send to individual dashboard page and add proper commenting
        response.setViewName("redirect:/user/dashboard");

        return response;
    }































}
