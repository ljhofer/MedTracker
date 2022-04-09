package medtrackercapstone.medtracker.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "med_purpose")
    private String medPurpose;

    @Column(name = "special_instructions")
    private String specialInstructions;

//    @OneToMany(mappedBy = "medication", fetch = FetchType.EAGER )
//    private List<UserMed> userMeds = new ArrayList();



}
