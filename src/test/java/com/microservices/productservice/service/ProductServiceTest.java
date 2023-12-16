package com.microservices.productservice.service;

import com.microservices.productservice.domain.model.Product;
import com.microservices.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
   @Mock
    private ProductRepository productRepository;

   @Test
   public void shouldGetAllProducts(){
       List<Product> productList=new ArrayList<>();
       productList.add(Product.builder()
               .name("irisi")
               .description("chi haja")
               .price(BigDecimal.valueOf(14.2))
               .build());
        given(productRepository.findAll()).willReturn(productList);
//       when(productRepository.findAll()).thenReturn(productList);
       List<Product> products = productRepository.findAll();
       assertEquals(productList.size(),1);
   }

}
