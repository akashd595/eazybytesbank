package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold Response information"
)
public class ResponseDTO {
    @Schema(
        name = "Status code"
    )
    private String statusCode;
    @Schema(
            name = "Status Message"
    )
    private String statusMessage;
}
