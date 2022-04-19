package medtrackercapstone.medtracker.database.dao;


import medtrackercapstone.medtracker.database.entity.UserMed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface UserMedDAO extends JpaRepository<UserMed, Integer> {

    List<UserMed> findByUserId (@Param("userId") Integer userId);

    @Query(value= "select * from user_meds where user_id = :userId and status = 'active'", nativeQuery = true)
    List<UserMed> findByIdAndActive ( Integer userId);

    @Query(value= "select * from user_meds where user_id = :userId and status = 'inactive'", nativeQuery = true)
    List<UserMed> findByIdAndInactive ( Integer userId);

    @Query("SELECT um.dosage, m.specialInstructions FROM UserMed um JOIN Medication m ON um.medication.id = m.id where um.medication.id= :medId and um.user.id= :userId ")
    String findByMedId ( Integer medId, Integer userId);

}
