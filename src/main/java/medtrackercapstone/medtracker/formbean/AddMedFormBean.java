package medtrackercapstone.medtracker.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
public class AddMedFormBean {

    private Integer id;

    @NotBlank(message = "Medication is required")
    private Integer medName;

    @NotBlank(message = "Frequency is required")
    private Integer frequency;

    @NotBlank(message = "Dosage is required")
    private String dosage;

}
