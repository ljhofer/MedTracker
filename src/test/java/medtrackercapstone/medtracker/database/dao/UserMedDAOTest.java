package medtrackercapstone.medtracker.database.dao;


import medtrackercapstone.medtracker.database.entity.User;
import medtrackercapstone.medtracker.database.entity.UserMed;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserMedDAOTest {

    @Autowired
    private UserMedDAO userMedDao;

    UserMed userMed;

    @BeforeEach
    void name() { userMed = new UserMed("80 mg", 24, "active"); }

    // Test for creating a userMed
    @Test
    @Order(1)
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
        userMedDao.save(userMed);


    }


    // Test for updating userMed
    @Test
    @Order(3)
    public void updateUserMedTest() {
        userMedDao.save(userMed);


    }


    // Test for changing status or userMed
    @Test
    @Order(4)
    public void removeUserMedTest() {
        userMedDao.save(userMed);


    }


}
