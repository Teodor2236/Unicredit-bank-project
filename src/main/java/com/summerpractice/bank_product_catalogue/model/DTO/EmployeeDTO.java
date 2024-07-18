package com.summerpractice.bank_product_catalogue.model.DTO;

import com.summerpractice.bank_product_catalogue.model.enums.Role;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private String email;
    private int EGN;
    private String employeeNumber;
    private String password;
    private Role role;
}
