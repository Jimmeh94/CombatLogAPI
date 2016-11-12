package com.github.jimmeh.entries;

import org.spongepowered.api.text.Text;

public class CombatEntityEntry {

    //Entries are created when something is attacked,
    //These are for non-player entities

    private double damage;
    private Text attacker, attack;

    public CombatEntityEntry(double damage, Text attack, Text attacker){
        this.damage = damage;
        this.attack = attack;
        this.attacker = attacker;
    }

    public double getDamage() {
        return damage;
    }

    public Text getAttack() {
        return attack;
    }

    public Text getAttacker() {
        return attacker;
    }
}
