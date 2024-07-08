package crm.crm.DTO;

import lombok.Data;

@Data
public class ClientDTO {

    private Long id;
    private String name;
    private String email;
    private String adresse;
    private Long phoneNumber;

    // Getters and Setters
}
