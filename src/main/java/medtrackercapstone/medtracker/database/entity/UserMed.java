package medtrackercapstone.medtracker.database.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_meds")

public class UserMed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "dosage")
    private String dosage;

    @NonNull
    @Column(name = "frequency")
    private Integer frequency;

    @NonNull
    @Column(name = "status")
    private String status;

    @NonNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn( name = "med_id", nullable = false)
    private Medication medication;

    @NonNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn( name = "user_id", nullable = false)
    private User user;


}
