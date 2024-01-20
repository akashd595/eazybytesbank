package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Accounts information"
)
public class AccountsDTO {
    @NotEmpty(message = "Account number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be numeric and size should be 10 only")
    @Schema(
            name = "Account number",example = "2510362058"
    )
    private Long accountNumber;
    @NotEmpty(message = "account Type should not be empty")
    @Schema(
            name = "Account Type",example = "Savings"
    )
    private String accountType;
    @NotEmpty(message = "branch Address should not be empty")
    @Schema(
            name = "Branch Address",example="123 Chennai"
    )
    private String branchAddress;
}
