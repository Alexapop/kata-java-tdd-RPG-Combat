package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void characterShouldNotDamageItself() {
        Character character = new Character(FighterCharacter.MELEE);

        character.characterDamagesCharacter(character, 300, 1);

        assertEquals(1000, character.getHealth());
        assertTrue(character.isAlive());
    }

    @Test
    public void attackedCharacterShouldBeAliveIfDamageIsLowerThanHealth() {
        Character attacker = new Character(FighterCharacter.MELEE);
        Character attacked = new Character(FighterCharacter.MELEE);

        attacker.characterDamagesCharacter(attacked, 300, 1);

        assertEquals(700, attacked.getHealth());
        assertTrue(attacked.isAlive());
    }

    @Test
    public void attackedCharacterShouldBeDeadIfDamageIsHigherThanHealth() {
        Character attacker = new Character(FighterCharacter.MELEE);
        Character attacked = new Character(FighterCharacter.MELEE);

        attacker.characterDamagesCharacter(attacked, 1003, 1);

        assertEquals(0, attacked.getHealth());
        assertFalse(attacked.isAlive());
    }

    @Test
    public void characterShouldHealItselfIfAlive() {
        Character attacker = new Character(FighterCharacter.MELEE);
        Character healed = new Character(FighterCharacter.MELEE);

        attacker.characterDamagesCharacter(healed, 400, 1);
        healed.characterHealsItself(200);

        assertEquals(800, healed.getHealth());
        assertTrue(healed.isAlive());

    }

    @Test
    public void characterHealthShouldRemainAt1000IfHealingExceedsMaximum() {
        Character attacker = new Character(FighterCharacter.MELEE);
        Character healed = new Character(FighterCharacter.MELEE);

        attacker.characterDamagesCharacter(healed, 100, 1);
        healed.characterHealsItself(300);

        assertEquals(1000, healed.getHealth());
        assertTrue(healed.isAlive());

    }

    @Test
    public void meleeFighterShouldDamageTargetAtTwoMeters() {
        Character attacker = new Character(FighterCharacter.MELEE);
        Character target = new Character(FighterCharacter.MELEE);

        attacker.characterDamagesCharacter(target, 200, 2);

        assertEquals(800, target.getHealth());
    }

    @Test
    public void meleeFighterShouldNotDamageTargetBeyondTwoMeters() {
        Character attacker = new Character(FighterCharacter.MELEE);
        Character target = new Character(FighterCharacter.MELEE);

        attacker.characterDamagesCharacter(target, 200, 3);

        assertEquals(1000, target.getHealth());
    }

    @Test
    public void rangedFighterShouldDamageTargetAtTwentyMeters() {
        Character attacker = new Character(FighterCharacter.RANGED);
        Character target = new Character(FighterCharacter.MELEE);

        attacker.characterDamagesCharacter(target, 200, 20);

        assertEquals(800, target.getHealth());
    }

}
