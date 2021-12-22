package com.paynemiller.discrete.logic.exception;

public class BitStringLengthException extends Exception {
  public BitStringLengthException(String bitString1, String bitString2) {
    super(bitString1.concat(" and ").concat(bitString2).concat(" are not the same length!"));
  }
}
