package com.fawry.librarysystem.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class AuthorDTO {
    @NotBlank(message = "Name is mandatory")
    String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    String email;

    List<BookDTO> books;
}
