package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.LogDAO;
import medtrackercapstone.medtracker.database.dao.MedicationDAO;
import medtrackercapstone.medtracker.database.entity.Log;
import medtrackercapstone.medtracker.database.entity.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class LogController {
    @Autowired
    private LogDAO logDao;

    @RequestMapping(value = "/log", method = RequestMethod.GET )
    public ModelAndView findAll() {
        ModelAndView response = new ModelAndView();
        response.setViewName("/log");

        // Creates a new array of all medications
        List<Log> logs = new ArrayList<>();

        // Queries the database for all medications
        logs = logDao.findAll();

        // Adds med list to model
        response.addObject("logs", logs);

        return response;

    }
}
