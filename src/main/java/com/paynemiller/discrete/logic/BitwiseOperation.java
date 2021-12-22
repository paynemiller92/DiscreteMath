package com.paynemiller.discrete.logic;

import com.paynemiller.discrete.logic.exception.BitStringFormatException;
import com.paynemiller.discrete.logic.exception.BitStringLengthException;
import com.paynemiller.discrete.logic.exception.InvalidBitException;

public class BitwiseOperation {
  public static String and(String bitString1, String bitString2) throws BitStringLengthException, BitStringFormatException {
    return perform(Operation.AND, bitString1, bitString2);
  }

  public static String or(String bitString1, String bitString2) throws BitStringLengthException, BitStringFormatException {
    return perform(Operation.OR, bitString1, bitString2);
  }

  public static String exclusiveOr(String bitString1, String bitString2) throws BitStringLengthException, BitStringFormatException {
    return perform(Operation.XOR, bitString1, bitString2);
  }

  private static String perform(Operation operation, String bitString1, String bitString2) throws BitStringLengthException, BitStringFormatException {
    char[] bitCharacters1 = bitString1.toCharArray();
    char[] bitCharacters2 = bitString2.toCharArray();

    if (bitCharacters1.length != bitCharacters2.length) {
      throw new BitStringLengthException(bitString1, bitString2);
    }

    StringBuilder resultBuilder = new StringBuilder();

    for (int index = 0; index < bitCharacters1.length; index++) {
      boolean p, q, result = false;
      try {
        p = parseBitCharacter(bitCharacters1[index]);
      } catch (InvalidBitException exception) {
        throw new BitStringFormatException(bitString1);
      }

      try {
        q = parseBitCharacter(bitCharacters2[index]);
      } catch (InvalidBitException exception) {
        throw new BitStringFormatException(bitString2);
      }

      switch (operation) {
        case AND -> result = BooleanAlgebra.conjunction(p, q);
        case OR -> result = BooleanAlgebra.disjunction(p, q);
        case XOR -> result = BooleanAlgebra.exclusiveOr(p, q);
      }
      resultBuilder.append(result ? "1" : "0");
    }
    return resultBuilder.toString();
  }

  private static boolean parseBitCharacter(char bitCharacter) throws InvalidBitException {
    int bit = Integer.parseInt(String.valueOf(bitCharacter));
    if (bit != 0 && bit != 1) {
      throw new InvalidBitException();
    }
    return bit != 0;
  }

  private enum Operation {
    AND,
    OR,
    XOR
  }
}
