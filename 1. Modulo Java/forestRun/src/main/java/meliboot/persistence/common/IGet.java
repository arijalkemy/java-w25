package meliboot.persistence.common;

import java.util.Set;

public interface IGet<EntityResult> {
    public Set<EntityResult> getAll();
}
