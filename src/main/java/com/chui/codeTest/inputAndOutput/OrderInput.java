package com.chui.codeTest.inputAndOutput;

import com.chui.codeTest.model.MediaTypes;
import com.chui.codeTest.model.OrderItem;
import java.util.Scanner;

public class OrderInput {
  public static OrderItem askForOrder() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Please enter your order in this way: quantity type");

    String input = scanner.nextLine();

    String [] inputStringList = input.split(" ");

    if (inputStringList.length > 0) {
      return OrderItem.builder().
        quantity(Integer.parseInt(inputStringList[0])).
        mediaTypes(MediaTypes.valueOf(inputStringList[1])).
        build();
    }
    return null;
  }

  public static Menu selectMenuOption() {
    System.out.println("----------Please choose an option below-----------");
    for(Menu m : Menu.values()) {
      System.out.println(m.getOption() + " " + m.getContent());
    }
    Scanner scanner = new Scanner(System.in);

    String choice = scanner.nextLine();

    if (choice.isEmpty()) {
      System.out.println("Please choose an option");
    } else {
      for (Menu m : Menu.values()) {
        if (choice.equalsIgnoreCase(m.getOption())) {
          return m;
        }
      }
      System.out.println("Invalid Input, please choose one option below");
    }
    return null;
  }
}
