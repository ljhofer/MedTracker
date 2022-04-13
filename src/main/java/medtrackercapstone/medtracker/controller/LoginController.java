package medtrackercapstone.medtracker.controller;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.dao.UserDAO;
import medtrackercapstone.medtracker.database.entity.User;
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
public class LoginController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value= "/login/login", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        if(!StringUtils.equals("anonymousUser", currentPrincipalName)){
            User user = userDao.findByEmail(currentPrincipalName);
            response.addObject(user);
            response.setViewName("user/userDashboard/" + user.getId());
        }

        return response;

    }
}
