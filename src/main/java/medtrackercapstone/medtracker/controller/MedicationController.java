package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.MedicationDAO;
import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.entity.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MedicationController {

    @Autowired
    private MedicationDAO medicationDao;

    @RequestMapping(value = "/user/dashboard", method = RequestMethod.GET )
    public ModelAndView findAll() {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/dashboard");

        // Creates a new array of all medications
        List<Medication> meds = new ArrayList<>();

        // Queries the database for all medications
        meds = medicationDao.findAll();

        // Adds med list to model
        response.addObject("meds", meds);

        return response;

    }

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
