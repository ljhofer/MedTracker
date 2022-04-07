package medtrackercapstone.medtracker.database.dao;


import medtrackercapstone.medtracker.database.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDAO extends JpaRepository<Log, Long> {

    List<Log> findAll();
}
