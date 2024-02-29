package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.service.ISellerService;
import com.breakingbytes.be_java_hisp_w25_g04.utils.FactoryUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ProductControllerTests {

    @Mock
    ISellerService sellerService;

    @InjectMocks
    ProductController productController;

    @Test
    @DisplayName("T-0005: Correcto ordenamiento ascendente (date_asc)")
    public void orderByDateAscOkTest() {
        Integer userId = 1;
        String order = "date_asc";
        LastPostsDTO lastPostsDTO = FactoryUsers.getInstance().generateLastPostDto();

        ResponseEntity<LastPostsDTO> expectedResponse = new ResponseEntity<>(lastPostsDTO, HttpStatus.OK);

        when(sellerService.getPostOfVendorsFollowedByUser(userId, order)).thenReturn(lastPostsDTO);

        ResponseEntity<LastPostsDTO> currentResponse = productController.getPostOfVendorsFollowedByUser(userId, order);

        verify(sellerService, atLeast(1)).getPostOfVendorsFollowedByUser(userId, order);

        assertThat(expectedResponse).isEqualTo(currentResponse);
    }

    @Test
    @DisplayName("T-0005: Correcto ordenamiento descendente (date_desc)")
    public void orderByDateDescOkTest() {
        Integer userId = 1;
        String order = "date_desc";
        LastPostsDTO lastPostsDTO = FactoryUsers.getInstance().generateLastPostDto();

        ResponseEntity<LastPostsDTO> expectedResponse = new ResponseEntity<>(lastPostsDTO, HttpStatus.OK);

        when(sellerService.getPostOfVendorsFollowedByUser(userId, order)).thenReturn(lastPostsDTO);

        ResponseEntity<LastPostsDTO> currentResponse = productController.getPostOfVendorsFollowedByUser(userId, order);

        verify(sellerService, atLeast(1)).getPostOfVendorsFollowedByUser(userId, order);

        assertThat(expectedResponse).isEqualTo(currentResponse);
    }
}
