package com.paynemiller.discrete.logic;

public class BooleanAlgebra {
  public static boolean conjunction(boolean p, boolean q) {
    return p && q;
  }

  public static boolean disjunction(boolean p, boolean q) {
    return p || q;
  }

  public static boolean negation(boolean p) {
    return !p;
  }

  public static boolean exclusiveOr(boolean p, boolean q) {
    return p ^ q;
  }

  public static boolean implication(boolean p, boolean q) {
    return negation(p && negation(q));
  }

  public static boolean equivalence(boolean p, boolean q) {
    return disjunction(
            conjunction(p, q),
            conjunction(negation(p), negation(q))
    );
  }
}
