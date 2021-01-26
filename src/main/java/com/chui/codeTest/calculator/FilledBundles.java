package com.chui.codeTest.calculator;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FilledBundles {
  private List<BundleChoice> bundleChoiceList;

  public long countByBundleChoice(BundleChoice bundleChoice) {
    return this.bundleChoiceList
      .stream()
      .filter(xxx -> xxx.equals(bundleChoice)).count();
  }
}
