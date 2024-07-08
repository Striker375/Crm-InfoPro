package crm.crm.DTO;
import lombok.Data;

import java.util.Date;
@Data
public class CalenderEventDTO {

    private String title;
    private String description;
    private Date startTime;
    private Date endTime;
}