package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.MedicationDAO;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.database.entity.UserMed;
import medtrackercapstone.medtracker.formbean.AddMedicationFormBean;
import medtrackercapstone.medtracker.formbean.AddUserMedFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MedicationController {

    @Autowired
    private MedicationDAO medicationDao;

    // Method to set view on addMedication page
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/medication/addMed", method = RequestMethod.GET )
    public ModelAndView addMed() {
        ModelAndView response = new ModelAndView();
        response.setViewName("medication/addMed");

        AddMedicationFormBean form = new AddMedicationFormBean();
        response.addObject("form", form);

        return response;

    }

    // Method to add a medication record based on the information populated in the addMedication form
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/medication/addMedSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView addMedSubmit(@Valid AddMedicationFormBean form) throws Exception {
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

        // Creates new medication record and sets values equal to those in the form
        Medication medication = new Medication();

        medication.setName(form.getName());
        medication.setMedPurpose(form.getMedPurpose());
        medication.setSpecialInstructions(form.getSpecialInstructions());

        medicationDao.save(medication);

        // TODO: send to individual dashboard page and add proper commenting
        response.setViewName("redirect:/user/userDashboard");

        return response;
    }

    // Method to set view on medication search page
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/medication/searchMeds", method = RequestMethod.GET )
    public ModelAndView searchMed(@RequestParam (required = false) String searchMed) {
        ModelAndView response = new ModelAndView();
        response.setViewName("medication/searchMeds");

        List<Medication> meds = new ArrayList<>();

        if ( searchMed != null && !searchMed.isBlank()) {

            meds = medicationDao.findByName(searchMed);
        }

        response.addObject("meds", meds);

        response.addObject("searchMed", searchMed);

        return response;

    }


















//    @RequestMapping(value = "/medication/addUserMed", method = RequestMethod.GET )
//    public ModelAndView findAll() {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("medication/addUserMed");
//
//
//        AddUserMedFormBean form = new AddUserMedFormBean();
//        response.addObject("form", form);
//
////        // Creates a new array of all medications
//        List<Medication> meds = new ArrayList<>();
////
////        // Queries the database for all medications
//        meds = medicationDao.findAll();
////
////        // Adds med list to model
//        response.addObject("meds", meds);
//
//        return response;
//
//    }




}
