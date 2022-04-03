package com.icai.practicas.model;

import java.util.Arrays;
import java.util.regex.Pattern;

public record DNI(String dniValue) {

  private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
  private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
  private static final String[] INVALIDOS = new String[]{"00000000T", "00000001R", "99999999R"};

  public boolean validar() {
    return Arrays.binarySearch(INVALIDOS, dniValue) < 0 // (1)
            && REGEXP.matcher(dniValue).matches() // (2)
            && dniValue.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dniValue.substring(0, 8)) % 23); // (3)
  }
}