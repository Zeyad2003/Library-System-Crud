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

    @NotNull(message = "Id is mandatory")
    Long id;
    @NotBlank(message = "Name is mandatory")
    String name;

    @Min(value = 0, message = "Price should be positive")
    BigDecimal price;

    CategoryDTO category;

    List<Long> authorsIDs;
}
