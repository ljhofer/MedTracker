package medtrackercapstone.medtracker.database.dao;

import medtrackercapstone.medtracker.database.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDao;

    User user;

    @BeforeEach
    void name() {
        user = new User("ljhofer@gmail.com", "Laura", "asdfghjk1");
    }

    @Test
    public void findByEmailTest() {
        userDao.save(user);
        User user2 = userDao.findByEmail(user.getEmail());
        assertEquals(user2.getEmail(),"ljhofer@gmail.com");
        assertEquals(user2.getName(), "Laura");
        assertEquals(user2.getPassword(),"asdfghjk1");
    }



}
