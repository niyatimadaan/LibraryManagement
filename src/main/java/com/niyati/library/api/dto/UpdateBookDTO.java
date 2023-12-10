package com.niyati.library.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class UpdateBookDTO {
  private String name;
  private String author;

  @Min(value = 0, message = "Sales cannot be less than 0")
  private Long sales;
}
