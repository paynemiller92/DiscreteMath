package com.paynemiller.discrete.logic.exception;

public class BitStringFormatException extends Exception {
  public BitStringFormatException(String bitString) {
    super(bitString.concat(" is not a proper bit string. Please make sure only bits (1s or 0s) are present!"));
  }
}
