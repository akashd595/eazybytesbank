package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.lang.annotation.Documented;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documents",
				description = "Eazybank accounts",
				version = "v1",
				contact = @Contact(
						name = "Akash Das",
						email = "akash@das.com",
						url = "www.asd.com"
				),
				license = @License (
						name = "Apache 2.0",
						url = "www.asd.com"
				)
		),
		externalDocs = @ExternalDocumentation (
				description = "Eazybank accounts",
				url = "www.asd.com"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
