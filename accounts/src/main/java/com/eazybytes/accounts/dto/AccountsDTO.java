package com.eazybytes.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDTO {
    @NotEmpty(message = "Account number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be numeric and size should be 10 only")
    private Long accountNumber;
    @NotEmpty(message = "account Type should not be empty")
    private String accountType;
    @NotEmpty(message = "branch Address should not be empty")
    private String branchAddress;
}
