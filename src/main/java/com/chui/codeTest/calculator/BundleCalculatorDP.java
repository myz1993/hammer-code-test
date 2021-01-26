package com.chui.codeTest.calculator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class BundleCalculatorDP implements Calculator{

  @Override
  public FilledBundles calculate(List<BundleChoice> bundleChoices, int target) {

    double[] f = new double[target + 1];
    Map<Integer, List<BundleChoice>> map = new HashMap<>();

    f[0] = 0;

    IntStream.range(1, target + 1).forEach(i -> {
      f[i] = Integer.MAX_VALUE;

      for(BundleChoice bundleChoice: bundleChoices) {
        if ( i >= bundleChoice.getQuantity() && f[i - bundleChoice.getQuantity()] != Integer.MAX_VALUE) {
          if (f[i - bundleChoice.getQuantity()] + bundleChoice.getPrice() <= f[i]) {
            map.put( i,
              Stream.concat(
                new ArrayList<>(Arrays.asList(bundleChoice))
                  .stream(),
                map.getOrDefault(i - bundleChoice.getQuantity(), new ArrayList<>())
                  .stream()
              ).collect(Collectors.toList()));
            f[i] = f[i - bundleChoice.getQuantity()] + bundleChoice.getPrice();
          }
        }
      }
    });

    if (f[target] == Integer.MAX_VALUE) {
      f[target] = -1;
    }

    return new FilledBundles(map.getOrDefault(target, new ArrayList<>()));
  }
}
