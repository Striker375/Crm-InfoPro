package crm.crm.DTO;

import crm.crm.entity.Employee;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ContratDTO {
    private String details;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee employee;
}
