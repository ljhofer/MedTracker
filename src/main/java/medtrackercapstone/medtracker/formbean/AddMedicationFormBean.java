package medtrackercapstone.medtracker.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class AddMedicationFormBean {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String medPurpose;

    private String specialInstructions;





}
