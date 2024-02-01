package com.fawry.librarysystem.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Zeyad Nasef",
                        email = "zeyad.nasef.fci@gmail.com",
                        url = "https://www.facebook.com/zeiad.nasef/"
                ),
                description = "Library System RESTful API for managing authors, books, and categories.",
                title = "Library System API",
                version = "1.0.0"
        )
)
public class OpenApiConfig {
}