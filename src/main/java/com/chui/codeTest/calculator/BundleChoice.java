package com.chui.codeTest.calculator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BundleChoice {
  private int quantity;
  private double price;
}
