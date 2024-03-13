package com.clave.demo.service;

import com.clave.demo.dto.CompraDTO;

import java.util.List;

public interface ICompraService {
    public String createCompra(CompraDTO compraDTO);
    public List<CompraDTO> getAll();
}
