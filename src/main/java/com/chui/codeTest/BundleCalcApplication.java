package com.chui.codeTest;

import com.chui.codeTest.calculator.BundleCalculatorDP;
import com.chui.codeTest.inputAndOutput.Menu;
import com.chui.codeTest.inputAndOutput.OrderInput;
import com.chui.codeTest.inputAndOutput.OrderOutPut;
import com.chui.codeTest.model.OrderItem;
import com.chui.codeTest.model.OrderOutputItem;
import com.chui.codeTest.service.BundleService;

import java.util.List;
import java.util.Scanner;

public class BundleCalcApplication {

  public static void main(String[] args) {
    BundleService bundleService = new BundleService(new BundleCalculatorDP());

    do{
      Menu menuChoice = OrderInput.selectMenuOption();

      if (menuChoice != null) {
        switch (menuChoice) {
          case ORDER:
            OrderItem orderItem = OrderInput.askForOrder();

            List<OrderOutputItem> orderOutputItems = bundleService.getBestBundle(orderItem);

            OrderOutPut.output(orderOutputItems);
            break;

          case EXIT:
            System.out.println("Are you sure to exit the system? Press Y to confirm");
            Scanner sc = new Scanner(System.in);
            String confirmation = sc.nextLine();
            if (confirmation.equalsIgnoreCase("Y")) {
              System.out.println("------Thanks!------");
              System.exit(0);
            }
            break;
        }
      }
    } while (true);
  }
}
