package br.com.vsbreno.spring_boot_essentials.database.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Data
public class ProductEntity {

    private Integer id;
    private String name;
    private BigDecimal preco;
    private Integer quantidade;
}