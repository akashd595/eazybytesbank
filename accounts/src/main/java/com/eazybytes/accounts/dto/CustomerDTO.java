package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Accounts information"
)
public class CustomerDTO {
    @NotEmpty(message = "name should not be empty")
    @Size(min = 5, max = 35, message = "Name shouold be between 5 to 35 characters")
    @Schema(
            name = "Customer name",example = "akash"
    )
    private String name;
    @NotEmpty(message = "email should not be empty")
    @Email(message = "email address should be a valid one")
    @Schema(
            name = "email",example = "akashd595@gmail.com"
    )
    private String email;
    @NotEmpty(message = "mobile number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be numeric and size should be 10 only")
    @Schema(
            name = "mobile number",example="8754123652"
    )
    private String mobileNumber;

    private AccountsDTO accountsDTO;
}
