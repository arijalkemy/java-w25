package main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.dto.ServiceDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private String date;
    private String kilometers;
    private String description;

    public Service(ServiceDTO serviceDTO) {
        this.date = serviceDTO.getDate();
        this.kilometers = serviceDTO.getKilometers();
        this.description = serviceDTO.getDescription();
    }
}
