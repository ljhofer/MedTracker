package medtrackercapstone.medtracker.database.dao;

import medtrackercapstone.medtracker.database.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicationDAO extends JpaRepository<Medication, Integer> {

    List<Medication> findByNameContaining(@Param("name")String name);

}
