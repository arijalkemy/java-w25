package AutosConsesionario.service;

import AutosConsesionario.dto.DtoAuto;
import AutosConsesionario.entity.Auto;
import java.util.List;

public interface IServiceAutos {
    List<DtoAuto> viewAllAutos();
    boolean exitsAuto(int idAuto);
    void addAuto(Auto auto);
}
