package com.chui.codeTest.inputAndOutput;

import com.chui.codeTest.model.OrderOutputItem;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class OrderOutPut {
  public void output(List<OrderOutputItem> orderOutputItems) {
    System.out.println("The details of quotation is shown below:");
    System.out.println(" ");

    for (OrderOutputItem item : orderOutputItems) {
      System.out.println(item.getBundleAmount() + " x " + item.getBundleQuantity() + "@$" + item.getBundlePrice());
    }
    System.out.println(" ");

  }
}
