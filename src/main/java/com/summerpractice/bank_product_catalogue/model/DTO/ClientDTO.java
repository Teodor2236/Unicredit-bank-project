package com.summerpractice.bank_product_catalogue.model.DTO;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int EGN;
    private String clientNumber;
    private Set<ProductDTO> products;
}
