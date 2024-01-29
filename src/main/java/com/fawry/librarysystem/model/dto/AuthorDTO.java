package com.fawry.librarysystem.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    @NotNull(message = "Id is mandatory")
    Long id;

    @NotBlank(message = "Name is mandatory")
    String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    String email;

    List<Long> booksIDs;
}
