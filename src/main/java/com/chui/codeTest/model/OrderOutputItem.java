package com.chui.codeTest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrderOutputItem {
  private long bundleAmount;
  private int bundleQuantity;
  private double bundlePrice;
}
