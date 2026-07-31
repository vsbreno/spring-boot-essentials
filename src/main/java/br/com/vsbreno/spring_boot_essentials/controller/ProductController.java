package br.com.vsbreno.spring_boot_essentials.controller;


import br.com.vsbreno.spring_boot_essentials.database.model.ProductEntity;
import br.com.vsbreno.spring_boot_essentials.dto.ProductDTO;
import br.com.vsbreno.spring_boot_essentials.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> findAll(){
        return productService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }
}
