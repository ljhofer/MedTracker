package medtrackercapstone.medtracker.database.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user-meds")

public class UserMed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "timestamp")
    @Temporal(TemporalType.DATE)
    private Date takeMedDate;

    @Column(name = "taken")
    private Boolean taken;


    // Add foreign key for med_id


    // Add foreign key for user_id



}
