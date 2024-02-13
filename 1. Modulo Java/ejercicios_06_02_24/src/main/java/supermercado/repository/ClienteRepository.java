package supermercado.repository;

import supermercado.model.Cliente;

public interface ClienteRepository {
    Cliente getCliente();
    Cliente postCliente();
    Boolean deleteCliente();
    Cliente putCliente();
}
