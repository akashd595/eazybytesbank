package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Schema to hold Errors information"
)
public class ErrorResponseDTO {
    @Schema(
            name = "API Path"
    )
    private String apiPath;
    @Schema(
            name = "Error Code"
    )
    private HttpStatus errorCode;
    @Schema(
            name = "Error Message"
    )
    private String errorMessage;
    @Schema(
            name = "Error Time"
    )
    private LocalDateTime errorTime;
}
