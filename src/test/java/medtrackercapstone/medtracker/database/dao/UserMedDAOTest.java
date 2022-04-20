package medtrackercapstone.medtracker.database.dao;


import lombok.extern.slf4j.Slf4j;
import medtrackercapstone.medtracker.database.entity.Medication;
import medtrackercapstone.medtracker.database.entity.User;
import medtrackercapstone.medtracker.database.entity.UserMed;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserMedDAOTest {

    @Autowired
    private UserMedDAO userMedDao;

    private UserDAO userDao;

    private MedicationDAO medicationDao;

    UserMed userMed;

    User user;

    Medication medication;

    @BeforeEach
    void name() {

        user = new User("ljhofer@gmail.com", "Laura", "asdfghjk1");
        userDao.save(user);

        medication = new Medication( "Aspirin", "Pain reliever, Clot prevention", "Drink a full glass of water with each dose." );
        medicationDao.save(medication);

        userMed = new UserMed("80 mg", 24, "active", medicationDao.getById(medication.getId()), userDao.getById(user.getId()));

    }

    // Test for creating a userMed
    @Test
    @Order(1)
    @Rollback(value=false)
    public void createUserMedTest() {
        userMedDao.save(userMed);
        UserMed expected = userMedDao.getById(userMed.getId());
        assertEquals(expected.getDosage(), "80 mg");
        assertEquals(expected.getFrequency(), 24);
        assertEquals(expected.getStatus(), "active");

    }


    // Test for getting userMed
    @Test
    @Order(2)
    public void getUserMedTest() {
        UserMed expected = userMedDao.getById(4);
        assertEquals(expected.getId(), 4);

    }


    // Test for updating userMed
    @Test
    @Order(3)
    public void updateUserMedTest() {
        userMedDao.save(userMed);

        userMed = userMedDao.getById(userMed.getId());

        userMed.setDosage("400 mg");

        userMedDao.save(userMed);

        assertEquals(userMed.getDosage(), "400 mg");

    }


    // Test for changing status or userMed
    @Test
    @Order(4)
    public void removeUserMedTest() {
        userMedDao.save(userMed);

        userMed = userMedDao.getById(userMed.getId());

        userMed.setStatus("inactive");

        userMedDao.save(userMed);

        assertEquals(userMed.getDosage(), "inactive");

    }


}
