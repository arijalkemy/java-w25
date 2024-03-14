package bootcamp.crudjpajewerly.service;

import bootcamp.crudjpajewerly.dto.request.JewerlyRequest;
import bootcamp.crudjpajewerly.model.Jewerly;

import java.util.List;

public interface IJewerlyService {

    List<Jewerly> findJewerlys();
    Jewerly findJewerlyById(long id);
    void saveJewerly(JewerlyRequest Jewerly);
    void updateJewerly(Long id, JewerlyRequest Jewerly);
    void deleteJewerly(long id);

}
