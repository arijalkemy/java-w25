package meliboot.persistence.common;



public interface IRepository<Entity,EntityResult,TypeEntityId> extends IAdd<Entity>, IGet<EntityResult>,IDelete<TypeEntityId>{

}
