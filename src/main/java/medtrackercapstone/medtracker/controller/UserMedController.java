package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.MedicationDAO;
import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.dao.UserMedDAO;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.database.entity.User;
import medtrackercapstone.medtracker.database.entity.UserMed;
import medtrackercapstone.medtracker.formbean.AddUserMedFormBean;
import medtrackercapstone.medtracker.formbean.RemoveUserMedFormBean;
import medtrackercapstone.medtracker.formbean.UpdateUserMedFormBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        // If user is known then a new array of meds is created and added to the model
        if(!StringUtils.equals("anonymousUser", currentPrincipalName)){
            User user = userDao.findByEmail(currentPrincipalName);
            List<Medication> meds = medicationDao.findAll();
            response.addObject("meds", meds);
        }

        return response;
    }


    // Method to add a UserMed record based on the information populated in the addUserMed form
    @RequestMapping(value = "/userMed/addUserMedSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView addUserMedSubmit(@Valid AddUserMedFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

//        Checks for errors/missing fields in user input and displays the errors back to the user
        if (bindingResult.hasErrors() ) {
            for ( ObjectError error : bindingResult.getAllErrors()) {
                log.info( ((FieldError) error).getField()  + " " + error.getDefaultMessage() );
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            // If user is known then a new array of meds is created and added to the model
            if(!StringUtils.equals("anonymousUser", currentPrincipalName)){
                User user = userDao.findByEmail(currentPrincipalName);
                List<Medication> meds = medicationDao.findAll();
                response.addObject("meds", meds);
            }

            response.setViewName("/userMed/addUserMed");
            return response;
        }


        // If user is known creates new userMed record and sets values equal to those in the form

        if(!StringUtils.equals("anonymousUser", currentPrincipalName)){
            User user = userDao.findByEmail(currentPrincipalName);

            UserMed userMed = new UserMed();

            userMed.setFrequency(form.getFrequency());
            userMed.setDosage(form.getDosage());
            userMed.setStatus("active");
            userMed.setMedication(medicationDao.getById(form.getMedId()));

            userMed.setUser(user);

            userMedDao.save(userMed);

            // Redirects user to their dashboard page
            response.setViewName("redirect:/user/userDashboard/" + user.getId());
        }

        return response;
    }


    // Method to set view on updateUserMed page
    @RequestMapping(value = "/userMed/updateUserMed/{userMedId}", method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView updateUserMed(@PathVariable("userMedId") Integer userMedId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("userMed/updateUserMed");

        UpdateUserMedFormBean form = new UpdateUserMedFormBean();
        response.addObject("form", form);

        // Creates a new userMed and queries the database to populate form
        UserMed userMed = userMedDao.getById(userMedId);

        // Adds targeted userMed to model
        response.addObject("userMed", userMed);

        return response;

    }

    // Method to update a UserMed record
    @RequestMapping(value = "/userMed/updateUserMedSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView updateUserMedSubmit(@Valid UpdateUserMedFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

//        Checks for errors/missing fields in user input and displays the errors back to the user
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            UserMed userMed = userMedDao.getById(form.getId());
            response.addObject("userMed", userMed);

            response.setViewName("userMed/updateUserMed");
            return response;
        }

        // If user is known creates new userMed record and sets values equal to those in the form
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        if (!StringUtils.equals("anonymousUser", currentPrincipalName)) {
            User user = userDao.findByEmail(currentPrincipalName);
            UserMed userMed = new UserMed();

            userMed.setId(form.getId());
            userMed.setFrequency(form.getFrequency());
            userMed.setDosage(form.getDosage());
            userMed.setStatus("active");
            userMed.setMedication(medicationDao.getById(form.getMedId()));

            userMed.setUser(user);

            // Saves the updated userMed to the database
            userMedDao.save(userMed);

            // Redirects user to their dashboard page
            response.setViewName("redirect:/user/userDashboard/" + user.getId());
        }

        return response;
    }


        // Method for setting the page for removing a med
    @RequestMapping(value = "/userMed/removeUserMed/{userMedId}", method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView removeUserMed(@PathVariable("userMedId") Integer userMedId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("userMed/removeUserMed");

        RemoveUserMedFormBean form = new RemoveUserMedFormBean();
        response.addObject("form", form);

        // Creates a new userMed and queries the database to populate form
        UserMed userMed = userMedDao.getById(userMedId);

        // Adds targeted userMed to model
        response.addObject("userMed", userMed);

        log.info(userMed.toString());

        return response;
    }


        // Method for removing a med when a user done taking a medication
    @RequestMapping(value = "/userMed/removeUserMedSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView removeUserMedSubmit(@Valid RemoveUserMedFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

//        Checks for errors/missing fields in user input and displays the errors back to the user
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            UserMed userMed = userMedDao.getById(form.getId());
            response.addObject("userMed", userMed);

            response.setViewName("userMed/removeUserMed");
            return response;
        }

        // If user is known creates new userMed record and sets values equal to those in the form
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        if (!StringUtils.equals("anonymousUser", currentPrincipalName)) {
            User user = userDao.findByEmail(currentPrincipalName);
            UserMed userMed = new UserMed();

            userMed.setId(form.getId());
            userMed.setDosage(form.getDosage());
            userMed.setFrequency(form.getFrequency());
            userMed.setStatus("inactive");
            userMed.setMedication(medicationDao.getById(form.getMedId()));

            userMed.setUser(user);

            userMedDao.save(userMed);

            // Redirects user to their dashboard page
            response.setViewName("redirect:/user/userDashboard/" + user.getId());
        }

        return response;
    }

}
