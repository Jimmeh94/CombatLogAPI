package com.github.jimmeh.entries;

import org.spongepowered.api.text.Text;

import java.util.UUID;

public class CombatPlayerEntry extends CombatEntityEntry{

    //Use this for when the target is attacked by a player

    private UUID player;

    public CombatPlayerEntry(double damage, Text attack, Text attacker, UUID uuid) {
        super(damage, attack, attacker);
        this.player = uuid;
    }

    public UUID getPlayer() {
        return player;
    }
}
