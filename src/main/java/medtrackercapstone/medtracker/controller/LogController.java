package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.LogDAO;
import medtrackercapstone.medtracker.database.dao.MedicationDAO;
import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.entity.Log;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.database.entity.UserMed;
import medtrackercapstone.medtracker.formbean.AddUserLogFormBean;
import medtrackercapstone.medtracker.formbean.AddUserMedFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class LogController {

    @Autowired
    private LogDAO logDao;

    @Autowired
    private MedicationDAO medicationDao;

    @Autowired
    private UserDAO userDao;

//    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//
//    private Timestamp parseTimestamp(String timestamp) {
//        try {
//            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
//        } catch (ParseException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }

    // Method to set view on addUserLog page
    @RequestMapping(value = "/log/addUserLog", method = RequestMethod.GET )
    public ModelAndView addUserLog() {
        ModelAndView response = new ModelAndView();
        response.setViewName("/log/addUserLog");

        AddUserLogFormBean form = new AddUserLogFormBean();
        response.addObject("form", form);

        // Creates a new array of all medications
        List<Medication> meds = new ArrayList<>();

        // Queries the database for all medications
        // TODO: Later change this to the meds for that user
        meds = medicationDao.findAll();

        // Adds med list to model
        response.addObject("meds", meds);

        return response;

    }

    // Method to add a UserMed record based on the information populated in the addUserMedFormBean
    @RequestMapping(value = "/log/addUserLogSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView addUserLogSubmit(@Valid AddUserLogFormBean form) throws Exception {
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

        // Creates new userMed record and sets values equal to those in the form
        Log userLog = new Log();

        userLog.setMedication(medicationDao.getById(form.getMedId()));
        userLog.setSideEffects(form.getSideEffects());
        userLog.setCreatedOn(new Date());

//        // TODO make this populate with real user id
        userLog.setUser(userDao.getById(1));

        log.info(userLog.toString());

        logDao.save(userLog);

//        // TODO: send to individual dashboard page and add proper commenting
        response.setViewName("redirect:/user/userDashboard");

        return response;
    }








//        return response;

}
