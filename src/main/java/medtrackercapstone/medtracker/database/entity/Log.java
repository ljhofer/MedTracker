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
@Table(name = "medications")

public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="special_instructions")
    private String specialInstructions;

    @Column(name = "name")
    @Temporal(TemporalType.DATE)
    private Date createDate;


    // Add med foreign key here


}
