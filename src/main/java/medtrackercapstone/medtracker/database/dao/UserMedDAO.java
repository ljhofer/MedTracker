package medtrackercapstone.medtracker.database.dao;

import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.database.entity.UserMed;
import medtrackercapstone.medtracker.formbean.AddUserMedFormBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;



public interface UserMedDAO extends JpaRepository<UserMed, Integer> {

//    UserMed findById(@Param("id") Integer id);

    List<UserMed> findByUserId (@Param("userId") Integer userId);

}
