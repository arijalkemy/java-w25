package Supermercado.Interfaces;

import java.util.ArrayList;
import java.util.List;

import Supermercado.Models.Cliente;

public interface ICRUD<T>{
    void create(T record);
    void read();
    void update(T record);
    void delete(T record);
}
