package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void characterShouldNotDamageItself() {
        Character character = new Character();

        character.characterDamagesCharacter(character, 300);

        assertEquals(1000, character.getHealth());
        assertTrue(character.isAlive());
    }

    @Test
    public void damageShouldBeReducedBy50PercentWhenTargetIsFiveLevelsAbove() throws ReflectiveOperationException {
        Character attacker = new Character();
        Character target = new Character();

        setLevel(target, 6);

        attacker.characterDamagesCharacter(target, 200);

        assertEquals(900, target.getHealth());
    }

    @Test
    public void damageShouldBeIncreasedBy50PercentWhenTargetIsFiveLevelsBelow() throws ReflectiveOperationException {
        Character attacker = new Character();
        Character target = new Character();

        setLevel(attacker, 6);

        attacker.characterDamagesCharacter(target, 200);

        assertEquals(700, target.getHealth());
    }

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
    public void characterShouldHealItselfIfAlive() {
        Character attacker = new Character();
        Character healed = new Character();

        attacker.characterDamagesCharacter(healed, 400);
        healed.characterHealsItself(200);

        assertEquals(800, healed.getHealth());
        assertTrue(healed.isAlive());

    }

    @Test
    public void characterHealthShouldRemainAt1000IfHealingExceedsMaximum() {
        Character attacker = new Character();
        Character healed = new Character();

        attacker.characterDamagesCharacter(healed, 100);
        healed.characterHealsItself(300);

        assertEquals(1000, healed.getHealth());
        assertTrue(healed.isAlive());

    }

    private void setLevel(Character character, int level) throws ReflectiveOperationException {
        Field levelField = Character.class.getDeclaredField("level");
        levelField.setAccessible(true);
        levelField.setInt(character, level);
    }
}
