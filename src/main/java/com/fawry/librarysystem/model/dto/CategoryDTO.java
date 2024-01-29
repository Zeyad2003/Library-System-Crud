package com.fawry.librarysystem.model.dto;

import jakarta.validation.constraints.Max;
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
public class CategoryDTO {

    @NotBlank(message = "Name is mandatory")
    String name;

    @NotBlank(message = "Description is mandatory")
    String description;
}
