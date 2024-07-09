package crm.crm.DTO;

import crm.crm.Enum.LeaveType;
import lombok.Data;

import java.util.Date;
@Data

public class LeaveRequestDTO {
        private Long id;
        private Long employeeId;
        private Date startDate;
        private Date endDate;
        private LeaveType leaveType;

    }
