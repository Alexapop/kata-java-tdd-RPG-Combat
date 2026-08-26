package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void attackedCharacterShouldBeAliveIfDamageIsLowerThanHealth() {
        Character attacker = new Character();
        Character attacked = new Character();

        attacker.characterDamagesCharacter(attacked, 300);

        assertEquals(700, attacked.getHealth());
        assertTrue(attacked.isAlive());
    }

    @Test
    public void attackedCharacterShouldBeDeadIfDamageIsHigherThanHealth() {
        Character attacker = new Character();
        Character attacked = new Character();

        attacker.characterDamagesCharacter(attacked, 1003);

        assertEquals(0, attacked.getHealth());
        assertFalse(attacked.isAlive());
    }

    @Test
    public void characterShouldHealIfAlive() {
        Character healer = new Character();
        Character healed = new Character();

        healer.characterDamagesCharacter(healed, 400);
        healer.characterHealsCharacter(healed, 200);

        assertEquals(800, healed.getHealth());
        assertTrue(healed.isAlive());

    }

    @Test
    public void characterHealthShouldRemainAt1000IfHealingExceedsMaximum() {
        Character healer = new Character();
        Character healed = new Character();

        healer.characterDamagesCharacter(healed, 100);
        healer.characterHealsCharacter(healed, 300);

        assertEquals(1000, healed.getHealth());
        assertTrue(healed.isAlive());

    }
}
