package medtrackercapstone.medtracker.database.dao;


import medtrackercapstone.medtracker.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>  {

    User findByEmail(@Param("email") String email);

}
