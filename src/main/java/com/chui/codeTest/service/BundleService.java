package com.chui.codeTest.service;

import com.chui.codeTest.calculator.BundleChoice;
import com.chui.codeTest.calculator.Calculator;
import com.chui.codeTest.calculator.FilledBundles;
import com.chui.codeTest.constant.MediaBundles;
import com.chui.codeTest.mapper.BundleMapper;
import com.chui.codeTest.model.OrderItem;
import com.chui.codeTest.model.OrderOutputItem;
import com.chui.codeTest.model.SubmissionBundle;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BundleService {
  Calculator calculator;

  public List<OrderOutputItem> getBestBundle(OrderItem orderItem) {
    List<SubmissionBundle> submissionBundles = MediaBundles.BUNDLE_LIST.get(orderItem.getMediaTypes());
    List<BundleChoice> bundleChoices = BundleMapper.fromSubmissionBundleToBundleChoice(submissionBundles);
    FilledBundles filledBundles =  calculator.calculate(bundleChoices,orderItem.getQuantity());

    return BundleMapper.fromFilledBundlesToOutputItems(filledBundles);
  }
}
