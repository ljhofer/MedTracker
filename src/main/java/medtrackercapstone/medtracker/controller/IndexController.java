package medtrackercapstone.medtracker.controller;


import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.entity.User;
import medtrackercapstone.medtracker.security.AuthenticationFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AuthenticationFacade authentication;

    @RequestMapping(value= "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("index");

        String username = authentication.getAuthentication();
        User user = userDao.findByEmail(username);

        if(user !=null) {
            response.addObject(user);
            response.setViewName("redirect:/user/userDashboard/" + user.getId());

        }

        return response;

    }

}


