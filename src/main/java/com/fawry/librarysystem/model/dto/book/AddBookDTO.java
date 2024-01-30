package com.fawry.librarysystem.model.dto.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBookDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 0, message = "Price should be positive")
    private BigDecimal price;

    private String categoryName;
}