package com.factoriaf5.kata;

public class Character {
    private int health;
    private int level;
    private boolean alive;
    private final FighterCharacter fighterCharacter;

    public Character(FighterCharacter fighterCharacter) {
        health = 1000;
        level = 1;
        alive = true;
        this.fighterCharacter = fighterCharacter;
    }

    public void characterDamagesCharacter(Character target, int damage, int distance) {
        if (this == target) {
            return;
        }

        if (distance > fighterCharacter.getAttackRange()) {
            return;
        }
        if (target.level >= this.level + 5) {
            damage = damage / 2;
        } else if (this.level >= target.level + 5) {
            damage = damage + damage / 2;
        }

        target.health = target.health - damage;

        if (target.health > 0) {
            target.alive = true;
        } else {
            target.health = 0;
            target.alive = false;
        }

    }

    public void characterHealsItself(int healing) {
        if (!alive) {
            return;
        }
        health = Math.min(1000, health + healing);

    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }
}
