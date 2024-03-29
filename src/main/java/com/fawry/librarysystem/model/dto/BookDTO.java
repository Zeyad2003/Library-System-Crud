package com.fawry.librarysystem.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 0, message = "Price should be positive")
    private BigDecimal price;

    @NotNull(message = "Category is mandatory")
    @NotBlank(message = "Category is mandatory")
    private String category;

    private List<String> authors;
}