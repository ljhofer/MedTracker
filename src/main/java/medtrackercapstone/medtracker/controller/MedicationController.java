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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@Transactional
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
    public ModelAndView addMedSubmit(@Valid AddMedicationFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

//        Checks for errors/missing fields in user input and displays the errors back to the user
        if (bindingResult.hasErrors() ) {

            List<String> errorMessages = new ArrayList<>();
            for ( ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField()  + " " + error.getDefaultMessage() );
            }

            response.addObject("form", form);

            response.addObject("bindingResult", bindingResult);


            response.setViewName("/medication/addMed");
            return response;
        }

        // Creates new medication record and sets values equal to those in the form
        Medication medication = new Medication();

        medication.setName(form.getName());
        medication.setMedPurpose(form.getMedPurpose());
        medication.setSpecialInstructions(form.getSpecialInstructions());

        medicationDao.save(medication);

        // Redirects user back to search medications page
        response.setViewName("redirect:/medication/searchMeds" );

        return response;
    }


    // Method to set view on medication search page
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/medication/searchMeds", method = RequestMethod.GET )
    public ModelAndView searchMed(@RequestParam (required = false) String searchMed) {
        ModelAndView response = new ModelAndView();
        response.setViewName("medication/searchMeds");

        List<Medication> meds = new ArrayList<>();

//        If medication search is not null then queries the database for that medication and send it to the object
        if ( searchMed != null && !searchMed.isBlank()) {

            meds = medicationDao.findByNameContaining(searchMed);
        }

        response.addObject("meds", meds);
        response.addObject("searchMed", searchMed);

        return response;

    }


}
