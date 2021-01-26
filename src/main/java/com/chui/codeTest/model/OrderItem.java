package com.chui.codeTest.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
  private int quantity;

  private MediaTypes mediaTypes;
}
