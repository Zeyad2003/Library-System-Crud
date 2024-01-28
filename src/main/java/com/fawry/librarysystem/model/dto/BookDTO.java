package com.fawry.librarysystem.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

public class BookDTO {
    @NotBlank(message = "Name is mandatory")
    String name;

    @Min(value = 0, message = "Price should be positive")
    BigDecimal price;

    CategoryDTO category;
    List<AuthorDTO> authors;
}
