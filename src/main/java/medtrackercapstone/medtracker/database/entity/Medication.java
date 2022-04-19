package medtrackercapstone.medtracker.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "medication", fetch = FetchType.LAZY )
    private List<UserMed> userMeds = new ArrayList();

    @OneToMany(mappedBy = "medication", fetch = FetchType.LAZY)
    private List<Log> logs;

}
