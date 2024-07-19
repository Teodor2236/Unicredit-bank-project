package com.summerpractice.bank_product_catalogue.model.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String names;
    private String email;
    private String EGN;
    private String clientNumber;
    private String phone;
}
