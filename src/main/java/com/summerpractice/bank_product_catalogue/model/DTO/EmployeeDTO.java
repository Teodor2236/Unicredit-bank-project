package com.summerpractice.bank_product_catalogue.model.DTO;

import com.summerpractice.bank_product_catalogue.model.enums.Role;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String names;
    private String email;
    private String EGN;
    private String employeeNumber;
    private String password;
    private Role role;
}
