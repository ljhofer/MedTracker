package medtrackercapstone.medtracker.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
public class DeleteUserMedFormBean {

    private Integer id;

    private Integer medId;

    private Integer frequency;

    @NotBlank(message = "Dosage is required")
    private String dosage;
}
