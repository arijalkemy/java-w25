package meliboot.persistence.common;

public interface IAdapter<DTO,Model,Id> {
    public Model GetModel(DTO dto,Id id);
}
