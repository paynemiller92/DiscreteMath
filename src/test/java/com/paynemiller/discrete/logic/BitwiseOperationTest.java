package com.paynemiller.discrete.logic;

import com.paynemiller.discrete.logic.exception.BitStringFormatException;
import com.paynemiller.discrete.logic.exception.BitStringLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BitwiseOperationTest {
  private static final String BIT_STRING_1 = "0110110110";
  private static final String BIT_STRING_2 = "1100011101";

  @Test
  public void testBitwiseAnd() {
    String expectedResult = "0100010100";
    try {
      assertEquals(expectedResult, BitwiseOperation.and(BIT_STRING_1, BIT_STRING_2), "Bitwise AND is not evaluating correctly.");
    } catch (BitStringLengthException | BitStringFormatException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testBitwiseOr() {
    String expectedResult = "1110111111";
    try {
      assertEquals(expectedResult, BitwiseOperation.or(BIT_STRING_1, BIT_STRING_2), "Bitwise OR is not evaluating correctly.");
    } catch (BitStringLengthException | BitStringFormatException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testBitwiseExclusiveOr() {
    String expectedResult = "1010101011";
    try {
      assertEquals(expectedResult, BitwiseOperation.exclusiveOr(BIT_STRING_1, BIT_STRING_2), "Bitwise XOR is not evaluating correctly.");
    } catch (BitStringLengthException | BitStringFormatException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testInvalidBitString() {
    String badString = BIT_STRING_1.replace("1", "2");
    assertThrows(BitStringFormatException.class, () -> BitwiseOperation.and(badString, BIT_STRING_2), "Bitwise Operations are not detecting invalid bits.");
  }

  @Test
  public void testMismatchedBitStringLengths() {
    String longString = BIT_STRING_1.concat("11001100");
    assertThrows(BitStringLengthException.class, () -> BitwiseOperation.and(longString, BIT_STRING_2), "Bitwise Operations do not recognize when two strings are not of the same length.");
  }
}
