package medtrackercapstone.medtracker.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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


    // TODO: Add med foreign key here
//    @Column(name = "med_id")
//    private Integer medId;


    // TODO: Add user foreign key here
//    @Column(name = "user_id")
//    private Integer userId;

}
