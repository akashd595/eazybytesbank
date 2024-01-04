package com.eazybytes.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
    @NotEmpty(message = "name should not be empty")
    @Size(min = 5, max = 35, message = "Name shouold be between 5 to 35 characters")
    private String name;
    @NotEmpty(message = "email should not be empty")
    @Email(message = "email address should be a valid one")
    private String email;
    @NotEmpty(message = "mobile number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be numeric and size should be 10 only")
    private String mobileNumber;
    private AccountsDTO accountsDTO;
}
