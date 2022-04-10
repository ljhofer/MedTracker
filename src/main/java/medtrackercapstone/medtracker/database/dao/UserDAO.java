package medtrackercapstone.medtracker.database.dao;


import medtrackercapstone.medtracker.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>  {

//    User findById(@Param("id") Integer id);

    User findByEmail(@Param("email") String email);

}
