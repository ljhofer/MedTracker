package medtrackercapstone.medtracker.database.dao;

import medtrackercapstone.medtracker.database.entity.Medication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MedicationDAOTest {

    @Autowired
    private MedicationDAO medicationDao;

    Medication medication;

    @BeforeEach
    void name() { medication = new Medication( "Aspirin", "Pain reliever, Clot prevention", "Drink a full glass of water with each dose." ); }

    @Test
    public void findByNameContainingTest() {
        medicationDao.save(medication);
        List<Medication> medication2 = medicationDao.findByNameContaining(medication.getName());
        assertEquals(medication2.get(0).getName(), "Aspirin");
        assertEquals(medication2.get(0).getMedPurpose(), "Pain reliever, Clot prevention");
        assertEquals(medication2.get(0).getSpecialInstructions(), "Drink a full glass of water with each dose.");
    }

}
