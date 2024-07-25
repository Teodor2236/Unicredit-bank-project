package com.summerpractice.bank_product_catalogue.model.DTO;

import lombok.Data;

@Data
public class LoginRequest {

    private String employeeNumber;
    private String password;

}
