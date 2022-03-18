package com.veon.eurasia.alfabank.utils;

import java.util.Objects;

public class CardUtils {

  public static String getMaskedPan(String pan) {
    if (Objects.nonNull(pan)) {
      return pan.substring(0, 6) + "******" + pan.substring(pan.length() - 4);
    }

    return null;
  }
}
