package Supermercado.Controller;

import java.util.ArrayList;
import java.util.List;

import Supermercado.Interfaces.ICRUD;
import Supermercado.Models.Cliente;
import Supermercado.Models.Factura;

public class FacturaController implements ICRUD<Factura>{

    final List<Factura> facturas = new ArrayList<>();

    @Override
    public void create(Factura factura) {
        
    }

    @Override
    public void delete(Factura factura) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void read() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Factura factura) {
        // TODO Auto-generated method stub
        
    }
    
}
