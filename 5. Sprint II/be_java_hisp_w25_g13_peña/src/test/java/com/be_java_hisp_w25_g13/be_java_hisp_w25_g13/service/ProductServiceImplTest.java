package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ProductDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.ProductRepositoryImpl;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Utilities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    ProductRepositoryImpl productRepository;
    @InjectMocks
    ProductServiceImpl productService;

    @Test
    @DisplayName("addProduct Ok")
    void addProductOk(){
        //Arrange
        ProductDTO productDto = Utilities.generateProductDto(1, "arepa");
        Product product = Utilities.generateProduct(1, "arepa");
        //Act
        productService.addProduct(productDto);

        //Assert
        verify(productRepository, atLeastOnce()).addProduct(product);
    }
    @Test
    @DisplayName("listProducts Ok")
    void listProductsOk(){
        //Arrange
        List<Product> repoListProducts = Utilities.generateListProducts();
        List<ProductDTO> expectedListProductsDto = Utilities.generateListProductsDto();
        when(productRepository.getAll()).thenReturn(repoListProducts);
        //Act
        List<ProductDTO> listProductsDto = productService.getProducts();
        //Assert
        System.out.println(expectedListProductsDto);
        assertThat(expectedListProductsDto).usingRecursiveComparison().isEqualTo(listProductsDto);
    }
    @Test
    @DisplayName("getProductById Ok")
    void getProductByIdOk(){
        //Arrange
        Integer id = 1;
        Product repoProduct = Utilities.generateProduct(1, "Arepa");
        Optional<Product> expectedProduct = Optional.of(repoProduct);
        when(productRepository.getProductById(id)).thenReturn(Optional.of(repoProduct));

        //Act
        Optional<Product> product = productService.getProductById(id);

        //Assert
        assertThat(expectedProduct).usingRecursiveComparison().isEqualTo(product);
    }
}