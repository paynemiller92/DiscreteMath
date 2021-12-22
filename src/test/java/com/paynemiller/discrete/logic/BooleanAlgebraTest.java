package com.paynemiller.discrete.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ConstantConditions")
public class BooleanAlgebraTest {
  @Test
  public void testNegation() {
    assertAll(
            "values",
            () -> assertTrue(BooleanAlgebra.negation(false), "¬F doesn't evaluate to T."),
            () -> assertFalse(BooleanAlgebra.negation(true), "¬T doesn't evaluate to F.")
    );
  }

  @Test
  public void testConjunction() {
    assertAll(
            "values",
            () -> assertTrue(BooleanAlgebra.conjunction(true, true), "T ∧ T doesn't evaluate to T."),
            () -> assertFalse(BooleanAlgebra.conjunction(true, false), "T ∧ F doesn't evaluate to F."),
            () -> assertFalse(BooleanAlgebra.conjunction(false, true), "T ∧ T doesn't evaluate to F."),
            () -> assertFalse(BooleanAlgebra.conjunction(false, false), "T ∧ T doesn't evaluate to F.")
    );
  }

  @Test
  public void testDisjunction() {
    assertAll(
            "values",
            () -> assertTrue(BooleanAlgebra.disjunction(true, true), "T ⋁ T doesn't evaluate to T."),
            () -> assertTrue(BooleanAlgebra.disjunction(true, false), "T ⋁ F doesn't evaluate to F."),
            () -> assertTrue(BooleanAlgebra.disjunction(false, true), "T ⋁ T doesn't evaluate to F."),
            () -> assertFalse(BooleanAlgebra.disjunction(false, false), "T ⋁ T doesn't evaluate to F.")
    );
  }

  @Test
  public void testExclusiveOr() {
    assertAll(
            "values",
            () -> assertFalse(BooleanAlgebra.exclusiveOr(true, true), "T ⊕ T doesn't evaluate to F."),
            () -> assertTrue(BooleanAlgebra.exclusiveOr(true, false), "T ⊕ F doesn't evaluate to T."),
            () -> assertTrue(BooleanAlgebra.exclusiveOr(false, true), "F ⊕ T doesn't evaluate to T."),
            () -> assertFalse(BooleanAlgebra.exclusiveOr(false, false), "F ⊕ F doesn't evaluate to F.")
    );
  }

  @Test
  public void testImplication() {
    assertAll(
            "values",
            () -> assertTrue(BooleanAlgebra.implication(true, true), "T → T doesn't evaluate to T."),
            () -> assertFalse(BooleanAlgebra.implication(true, false), "T → F doesn't evaluate to F."),
            () -> assertTrue(BooleanAlgebra.implication(false, true), "F → T doesn't evaluate to T."),
            () -> assertTrue(BooleanAlgebra.implication(false, false), "F → F doesn't evaluate to T.")
    );
  }

  @Test
  public void testEquivalence() {
    assertAll(
            "values",
            () -> assertTrue(BooleanAlgebra.equivalence(true, true), "T ⟷ T doesn't evaluate to T."),
            () -> assertFalse(BooleanAlgebra.equivalence(true, false), "T ⟷ F doesn't evaluate to F."),
            () -> assertFalse(BooleanAlgebra.equivalence(false, true), "F ⟷ T doesn't evaluate to F."),
            () -> assertTrue(BooleanAlgebra.equivalence(false, false), "F ⟷ F doesn't evaluate to T.")
    );
  }
}
