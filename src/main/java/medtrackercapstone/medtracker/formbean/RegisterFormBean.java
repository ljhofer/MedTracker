package medtrackercapstone.medtracker.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
public class RegisterFormBean {

    private Integer id;

    @NotBlank(message = "Email is required")
//    Add in later
//    @EmailUnique(message = "Email is already in use.")
    @Email(message = "Not a valid email format")
    private String email;

    @NotBlank(message = "Name is required")
    private String name;

    @Length(min= 3, max= 15, message="Password must be between 3 and 15 characters.")
    @NotBlank(message="Password is required")
    private String password;

    @NotBlank(message="Confirm password is required")
    private String confirmPassword;


//    TODO: Add in code for dropdown


}
