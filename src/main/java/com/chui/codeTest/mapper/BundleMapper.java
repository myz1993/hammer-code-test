package com.chui.codeTest.mapper;

import com.chui.codeTest.calculator.BundleChoice;
import com.chui.codeTest.calculator.FilledBundles;
import com.chui.codeTest.model.OrderOutputItem;
import com.chui.codeTest.model.SubmissionBundle;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class BundleMapper {
  public List<BundleChoice> fromSubmissionBundleToBundleChoice(List<SubmissionBundle> submissionBundles) {
    return submissionBundles.stream().map(submissionBundle -> BundleChoice.
      builder().
      quantity(submissionBundle.getBundleQuantity()).
      price(submissionBundle.getPricePerBundle()).
      build()).
      collect(Collectors.toList());
  }

  public List<OrderOutputItem> fromFilledBundlesToOutputItems(FilledBundles filledBundles) {
    List<OrderOutputItem> orderOutputItems = new ArrayList<>();

    filledBundles.getBundleChoiceList()
      .stream()
      .forEach(bundleChoice -> {
        long count = filledBundles.countByBundleChoice(bundleChoice);
        orderOutputItems.add(
          OrderOutputItem
            .builder()
            .bundleAmount(count)
            .bundleQuantity(bundleChoice.getQuantity())
            .bundlePrice(bundleChoice.getPrice())
            .build()
        );
      });

    return new ArrayList<>(
      new HashSet<>(orderOutputItems));
  }
}

