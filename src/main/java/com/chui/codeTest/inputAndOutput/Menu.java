package com.chui.codeTest.inputAndOutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Menu {
  ORDER("A", "Place Order"),
  EXIT("E", "Exit The System");

  private final String option;
  private final String content;
}
