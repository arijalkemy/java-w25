package com.implementacionbd.ejercicio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.implementacionbd.ejercicio.dto.req.ProductReqDTO;
import com.implementacionbd.ejercicio.dto.res.ProductResDTO;
import com.implementacionbd.ejercicio.model.Product;
import com.implementacionbd.ejercicio.repository.IProductRepository;

@Service
public class ProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private Product productReqDTOToModel(ProductReqDTO productReqDTO) {
        return new Product(productReqDTO.getName(), productReqDTO.getAmount(), productReqDTO.getCostPrice(),
                productReqDTO.getSalePrice());
    }

    private ProductResDTO productModelToResDTO(Product product) {
        return new ProductResDTO(product.getId(), product.getName(), product.getAmount(), product.getCostPrice(),
                product.getSalePrice());
    }

    public List<ProductResDTO> findAllProducts() {
        Iterable<Product> productsIterable = productRepository.findAll();
        List<Product> productsList = StreamSupport.stream(productsIterable.spliterator(), false)
                .collect(Collectors.toList());
        List<ProductResDTO> productsResDTOList = new ArrayList<>();
        for (Product e : productsList) {
            productsResDTOList.add(productModelToResDTO(e));
        }
        return productsResDTOList;
    }

    public String saveProduct(ProductReqDTO productReqDTO) {
        productRepository.save(productReqDTOToModel(productReqDTO));
        return "Ok";
    }

    public String deleteProduct(String id) {
        productRepository.deleteById(id);
        return "Ok";
    }

    public String updateProduct(String id, ProductReqDTO productReqDTO) {
        Product product = productReqDTOToModel(productReqDTO);
        product.setId(id);
        productRepository.save(product);
        return "Ok";
    }
}
