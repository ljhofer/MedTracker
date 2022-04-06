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
@Table(name = "logs")

public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "side_effects")
    private String sideEffects;

    @Column(name = "timestamp")
    @Temporal(TemporalType.DATE)
    private Date createDate;


    // Add med foreign key here


}
