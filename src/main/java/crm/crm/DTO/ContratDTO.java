package crm.crm.DTO;

import crm.crm.entity.Employee;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ContratDTO {
    private String details;
    private Date startDate;
    private Date endDate;
    private Employee employee;
}
