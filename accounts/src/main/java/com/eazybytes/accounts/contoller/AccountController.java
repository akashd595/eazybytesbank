package com.eazybytes.accounts.contoller;

import com.eazybytes.accounts.constant.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.dto.ErrorResponseDTO;
import com.eazybytes.accounts.dto.ResponseDTO;
import com.eazybytes.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Tag(
    name = "CRUD Operations for Accounts microservice",
    description = "CREATE UPDATE DELETE & FETCH APIs"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {

    private IAccountsService iAccountsService;
    @GetMapping("sayHello")
    public String sayHello(){
        return "Hi World";
    }

    @Operation(
        summary = "CREATE API",
        description = "API to crreate a new customer and Account"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO){
        iAccountsService.createAccount(customerDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }
    @Operation(
            summary = "FETCH API",
            description = "API to FETCH the customer and Account"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS OK"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails( @RequestParam
        @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be numeric and size should be 10 only")
        String mobileNumber ){
        CustomerDTO customerDTO = iAccountsService.fetchAccount(mobileNumber);

        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @Operation(
        summary = "UPDATE API",
        description = "API to update a existing customer and Account"
    )
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "HTTP STATUS OK"
        ),@ApiResponse(
            responseCode = "417",
            description = "Exception Failed"
        ),
        @ApiResponse(
                responseCode = "500",
                description = "HTTP STATUS INTERNAL SERVER ERROR",
                content = @Content(
                        schema = @Schema(implementation = ErrorResponseDTO.class)
                )
        )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@Valid @RequestBody CustomerDTO customerDTO){
        boolean isUpdated = iAccountsService.updateAccount(customerDTO);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_UPDATE));
        }
    }
    @Operation(
        summary = "DELETE API",
        description = "API to delete a existing customer and Account"
    )
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "HTTP STATUS OK"
        ),
        @ApiResponse(
                responseCode = "417",
                description = "Exception Failed"
        ),
        @ApiResponse(
                responseCode = "500",
                description = "HTTP STATUS INTERNAL SERVER ERROR",
                content = @Content(
                        schema = @Schema(implementation = ErrorResponseDTO.class)
                )
        )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccount(@RequestParam
         @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be numeric and size should be 10 only")
         String mobileNumber) {
        boolean isDelete = iAccountsService.deleteAccount(mobileNumber);
        if( isDelete ){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_DELETE));
        }
    }

}
