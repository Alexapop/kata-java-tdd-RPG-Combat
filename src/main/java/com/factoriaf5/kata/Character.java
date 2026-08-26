package com.factoriaf5.kata;

public class Character {
    private int health;
    private int level;
    private boolean alive;

    public Character() {
        health = 1000;
        level = 1;
        alive = true;
    }

    public void characterDamagesCharacter(Character attacked, int damage) {
        attacked.health = attacked.health - damage;

        if (attacked.health > 0) {
            attacked.alive = true;
        } else {
            attacked.health = 0;
            attacked.alive = false;
        }

    }

    public void characterHealsCharacter(Character healed, int healing) {
        if (!healed.alive) {
            return;
        }
        healed.health = Math.min(1000, healed.health + healing);

    }

    public int getHealth(){
        return health;
    }

    public int getLevel(){
        return level;
    }

    public boolean isAlive(){
        return alive;
    }
}
