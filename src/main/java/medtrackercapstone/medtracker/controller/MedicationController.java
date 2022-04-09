package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.MedicationDAO;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.formbean.AddUserMedFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MedicationController {

    @Autowired
    private MedicationDAO medicationDao;

    // Method to set view on addMedication page
    @RequestMapping(value = "/medication/addUserMed", method = RequestMethod.GET )
    public ModelAndView findAll() {
        ModelAndView response = new ModelAndView();
        response.setViewName("medication/addUserMed");


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




}
