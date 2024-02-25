package meliboot.services.common.interfaces;

import java.util.Set;

public interface IGet<EntityResult> {
    public Set<EntityResult> getAll();
}
