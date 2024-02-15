package bootcamp.repository;

import bootcamp.entity.Plate;

import java.util.List;

public interface IPlateRepository {

    public List<Plate> loadPlates();
}
