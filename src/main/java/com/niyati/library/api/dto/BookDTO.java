package com.niyati.library.api.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
public class BookDTO {
  private String id;
  private String name;
  private String author;
  private Long sales;
}
