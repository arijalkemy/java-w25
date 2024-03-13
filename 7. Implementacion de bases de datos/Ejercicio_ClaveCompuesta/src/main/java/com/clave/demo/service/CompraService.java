package com.clave.demo.service;

import com.clave.demo.dto.CompraDTO;
import com.clave.demo.model.Compra;
import com.clave.demo.repository.ICompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService implements ICompraService {

    private ICompraRepository compraRepo;

    public CompraService(ICompraRepository compraRepo) {
        this.compraRepo = compraRepo;
    }

    @Override
    public String createCompra(CompraDTO compraDTO) {
        Compra compra = new Compra();
        compra.setClienteId(compraDTO.getClienteId());
        compra.setFecha(compraDTO.getFecha());
        compra.setDescripcion(compraDTO.getDescripcion());
        compraRepo.save(compra);
        return "Compra creada correctamente.";
    }

    @Override
    public List<CompraDTO> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<Compra> lista = compraRepo.findAll();
        return lista.stream().map(c -> mapper.map(c, CompraDTO.class)).toList();
    }
}
