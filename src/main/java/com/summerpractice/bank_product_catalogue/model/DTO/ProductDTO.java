package com.summerpractice.bank_product_catalogue.model.DTO;

import com.summerpractice.bank_product_catalogue.model.entity.ProductDetails;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private boolean isActive;
    private String type;
    private String image_url;
    private String description;
    private ProductDetails productDetails;
    private Set<ClientDTO> clients;

}
