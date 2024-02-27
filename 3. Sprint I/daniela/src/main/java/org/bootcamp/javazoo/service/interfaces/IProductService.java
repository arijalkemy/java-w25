package org.bootcamp.javazoo.service.interfaces;

import org.bootcamp.javazoo.dto.ProductDto;
import org.bootcamp.javazoo.entity.Product;

public interface IProductService {
    ProductDto mapToProductDto (Product productToMap);
    Product convertDtoToProduct(ProductDto productDto);
    Product convertDtoToPostPromo(ProductDto productDto);

}
