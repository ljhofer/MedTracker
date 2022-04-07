package medtrackercapstone.medtracker.controller;


import lombok.extern.slf4j.Slf4j;
//import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.entity.User;
import medtrackercapstone.medtracker.formbean.RegisterFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        // Preseeding the form
        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }
//
//    // This method now becomes a create and an edit based on if the user id is populated in the registerFormBean
//    @RequestMapping(value = "/user/registerSubmit", method = RequestMethod.POST)
//    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
//        ModelAndView response = new ModelAndView();
//
//        if (bindingResult.hasErrors() ) {
//            for ( ObjectError error : bindingResult.getAllErrors()) {
//                log.info( ((FieldError) error).getField()  + " " + error.getDefaultMessage() );
//            }
//
//            // because there is one or more error we do not want to process the logic below
//            // that will creat a new user in the database we want to show the same model that we are already on
//            response.setViewName("/user/register");
//            return response;
//        }
//
//        // first try to load the user from the database using the incoming id on the form
//        User user = userDao.findById(form.getId());
//
//        //now if the id from the database is null then it is a create
//        if ( form.getId() == null ) {
//
//            user = new User();
//
//        }
//
//        user.setEmail(form.getEmail());
//        user.setName(form.getName());
//        user.setPassword(form.getPassword());
//
//        userDao.save(user);
//
//        log.info(form.toString());
//
//        // Will send us to the edit page for this user which will be responsible for loading the user from the database and rendering the info
//        // When you use redirect: it tells spring to tredirect page, uses an actual URL rather than a view name path
//        response.setViewName("redirect:/user/edit/" + user.getId());
//
//        return response;
//    }
}
