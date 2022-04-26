package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.dao.UserMedDAO;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.database.entity.User;
import medtrackercapstone.medtracker.database.entity.UserMed;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class AjaxController {

    @Autowired
    private UserMedDAO userMedDao;

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public ModelAndView ajaxView() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("ajax");

        return response;
    }

    // Method queries the database for the dosage and special instructions for the medication chosen in the log
    @RequestMapping(value = "/ajaxRequest", method = RequestMethod.GET)
    public ResponseEntity<List<String>> ajaxRequest(@RequestParam Integer chosenMedId) throws Exception {

        List<String> splitList = new ArrayList<>();


        // Finds the current user id to query their userMeds
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        if(!StringUtils.equals("anonymousUser", currentPrincipalName)){
            User user = userDao.findByEmail(currentPrincipalName);
            String userMed = userMedDao.findByMedId(chosenMedId, user.getId());

            String[] split = userMed.split(",");

            splitList = Arrays.asList(split);

        }

        // returns split list of string to the JSP
        return new ResponseEntity<>(splitList, HttpStatus.OK);
    }

}
