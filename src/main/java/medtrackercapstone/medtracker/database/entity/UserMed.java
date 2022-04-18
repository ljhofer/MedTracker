package medtrackercapstone.medtracker.database.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_meds")

public class UserMed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "frequency")
    private Integer frequency;

    @Column(name = "status")
    private String status;


//     Add foreign key for med_id
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn( name = "med_id", nullable = false)
    private Medication medication;



//     Add foreign key for user_id
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn( name = "user_id", nullable = false)
    private User user;


}
