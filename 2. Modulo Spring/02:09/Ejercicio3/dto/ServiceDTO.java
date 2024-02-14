package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.entity.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO {
    private String date;
    private String kilometers;
    private String description;

    public ServiceDTO(Service service) {
        this.date = service.getDate();
        this.kilometers = service.getKilometers();
        this.description = service.getDescription();
    }
}
