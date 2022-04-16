package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.UserMedDAO;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.database.entity.UserMed;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private UserMedDAO userMedDAO;

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public ModelAndView ajaxView() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("ajax");

        return response;
    }

    @RequestMapping(value = "/ajaxRequest", method = RequestMethod.GET)
    public ResponseEntity<List<String>> ajaxRequest(@RequestParam Integer chosenMedId) throws Exception {
        String userMed = userMedDAO.findByMedId(chosenMedId, 1);

        String[] split = userMed.split(",");

        List<String> splitList = Arrays.asList(split);

        return new ResponseEntity<>(splitList, HttpStatus.OK);
    }

}
