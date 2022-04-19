package medtrackercapstone.medtracker.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
public class RemoveUserMedFormBean {

    private Integer id;

    private Integer medId;

    private Integer frequency;

    private String dosage;

    @NotBlank
    private String confirmRemove;
}
