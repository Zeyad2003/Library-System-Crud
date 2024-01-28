package com.fawry.librarysystem.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class CategoryDTO {
    @NotBlank(message = "Name is mandatory")
    String name;

    @NotBlank(message = "Description is mandatory")
    String description;

    @Max(value = 5, message = "Stars should be less than or equal to 5")
    @Min(value = 0, message = "Stars should be greater than or equal to 0")
    BigDecimal stars;
}
