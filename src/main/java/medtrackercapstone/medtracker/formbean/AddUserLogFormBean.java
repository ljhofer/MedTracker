package medtrackercapstone.medtracker.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class AddUserLogFormBean {

    private Integer id;

    private Integer medId;

    private String sideEffects;

//    private Timestamp createdOn;

}
