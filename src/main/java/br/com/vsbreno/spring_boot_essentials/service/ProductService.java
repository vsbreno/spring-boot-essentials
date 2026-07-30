package br.com.vsbreno.spring_boot_essentials.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vsbreno.spring_boot_essentials.database.model.ProductEntity;

@Service
public class ProductService {

    private static final List<ProductEntity> PRODUCTS = List.of(
            ProductEntity.builder()
                    .id(1)
                    .name("Notebook")
                    .preco(new BigDecimal("5000"))
                    .quantidade(10)
                    .build(),
            ProductEntity.builder()
                    .id(2)
                    .name("Iphone")
                    .preco(new BigDecimal("7000"))
                    .quantidade(10)
                    .build(),
            ProductEntity.builder()
                    .id(1)
                    .name("Mouse")
                    .preco(new BigDecimal("500"))
                    .quantidade(10)
                    .build()
    );

    public List<ProductEntity> findAll() {
        return new ArrayList<>(PRODUCTS);
    }
}
