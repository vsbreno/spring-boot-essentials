package br.com.vsbreno.spring_boot_essentials.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.vsbreno.spring_boot_essentials.dto.ProductDTO;
import br.com.vsbreno.spring_boot_essentials.exception.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.vsbreno.spring_boot_essentials.database.model.ProductEntity;

@Service
public class ProductService {

    private static final List<ProductEntity> PRODUCTS = new ArrayList<>();

    static {
        PRODUCTS.add(ProductEntity.builder()
                .id(1)
                .name("Notebook")
                .preco(new BigDecimal("5000"))
                .quantidade(10)
                .build());

        PRODUCTS.add(ProductEntity.builder()
                .id(2)
                .name("Iphone")
                .preco(new BigDecimal("7000"))
                .quantidade(10)
                .build());

        PRODUCTS.add(ProductEntity.builder()
                .id(3)
                .name("Mouse")
                .preco(new BigDecimal("500"))
                .quantidade(10)
                .build());
    }

    public List<ProductEntity> findAll() {
        return new ArrayList<>(PRODUCTS);
    }

    public ProductEntity createProduct(ProductDTO productDTO) {

        Integer identify = PRODUCTS.stream()
                .mapToInt(ProductEntity::getId)
                .max()
                .orElse(0) + 1;

        ProductEntity newProduct = ProductEntity.builder()
                .id(identify)
                .name(productDTO.getName())
                .preco(productDTO.getPreco())
                .quantidade(productDTO.getQuantidade())
                .build();

        PRODUCTS.add(newProduct);

        return newProduct;
    }

    public ProductEntity updateProduct(ProductDTO productDTO, Integer id) throws NotFoundException {

        ProductEntity product = PRODUCTS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Product not found."));

        product.setName(productDTO.getName());
        product.setPreco(productDTO.getPreco());
        product.setQuantidade(productDTO.getQuantidade());

        return product;
    }

    public void removeProduct(Integer id){
        PRODUCTS.removeIf(productId -> productId.getId().equals(id));
    }
}
