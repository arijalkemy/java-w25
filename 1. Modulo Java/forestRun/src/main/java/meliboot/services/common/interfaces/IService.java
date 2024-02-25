package meliboot.services.common.interfaces;

public interface IService<Entity,EntityResult,TypeId> extends ICreate<Entity>, IGet<EntityResult>, IDelete<TypeId>
{

}
