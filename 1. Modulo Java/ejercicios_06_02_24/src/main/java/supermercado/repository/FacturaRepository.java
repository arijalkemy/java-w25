package supermercado.repository;

import supermercado.model.Factura;

public interface FacturaRepository {
    Factura getFactura();
    Factura postFactura();
    Factura deleteFactura();
    Factura putFactura();
}
