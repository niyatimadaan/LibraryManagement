package com.niyati.library.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class CreateBookDTO {
  @NotNull(message = "Name is required")
  @NotBlank(message = "Name should be valid")
  private String name;

  @NotNull(message = "Author is required")
  @NotBlank(message = "Author should be valid")
  private String author;

  @NotNull(message = "Sales is required")
  @Min(value = 0, message = "Sales cannot be less than 0")
  private Long sales;
}
