package com.factoriaf5.kata;

public enum FighterCharacter {
    MELEE(2),
    RANGED(20);

    private final int attackRange;

    FighterCharacter(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getAttackRange() {
        return attackRange;
    }
}
