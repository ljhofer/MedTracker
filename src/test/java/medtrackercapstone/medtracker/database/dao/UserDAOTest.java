package medtrackercapstone.medtracker.database.dao;

import medtrackercapstone.medtracker.database.entity.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @Order(1)
    public void findByEmailTest() {
        userDao.save(user);
        User user2 = userDao.findByEmail(user.getEmail());
        assertEquals(user2.getEmail(),"ljhofer@gmail.com");
        assertEquals(user2.getName(), "Laura");
        assertEquals(user2.getPassword(),"asdfghjk1");
    }


    @Order(2)
    @ParameterizedTest
    @CsvSource({"abby@broadcity.com, Abby, asdfghjk1", "ilana@braodcity.com, Ilana, asdfghjk1"})
    void parameterizedTest(String email, String name, String password) {
        User expected = new User();
        expected.setEmail(email);
        expected.setName(name);
        expected.setPassword(password);
        userDao.save(expected);

        User actual = userDao.findByEmail(expected.getEmail());

        assertEquals(expected.getEmail(), actual.getEmail());

    }




}
