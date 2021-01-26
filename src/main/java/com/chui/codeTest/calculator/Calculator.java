package com.chui.codeTest.calculator;

import java.util.List;

public interface Calculator {
  FilledBundles calculate(List<BundleChoice> bundleChoices, int target);
}
