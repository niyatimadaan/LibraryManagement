package com.niyati.library.api.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorDTO {
  private Integer status;
  private List<String> errors;
}