package com.github.jimmeh.entity;

import com.github.jimmeh.entries.CombatEntityEntry;
import com.github.jimmeh.CombatLogAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EntityInfo {

    private List<CombatEntityEntry> entries = new ArrayList<>();
    private Long lastShot, lastHit;
    private boolean inCombat = false, canReceiveDamage = true;
    private UUID uuid;

    public void displayEntries(){};

    public EntityInfo(UUID uuid){this.uuid = uuid;}

    //Entries are only for when the entity gets hit
    public void addEntry(CombatEntityEntry entry){
        entries.add(0, entry);
        if(entries.size() > 5){
            for(int i = 5; i < entries.size(); i++){
                entries.remove(i);
            }
        }
        lastHit = System.currentTimeMillis();
        setInCombat(true);
    }

    public void tickInCombat(){
        if(lastShot == null && lastHit == null)
            return;

        double shotDifference, hitDifference;

        if(lastShot != null) {
            shotDifference = System.currentTimeMillis() - lastShot;
            if(shotDifference <= CombatLogAPI.getCombatInterval()){
                setInCombat(true);
            } else setInCombat(false);
        }
        if(lastHit != null) {
            hitDifference = System.currentTimeMillis() - lastHit;
            if(hitDifference <= CombatLogAPI.getCombatInterval()){
                setInCombat(true);
            } else setInCombat(false);
        }
    }

    public void setLastShot() {
        this.lastShot = System.currentTimeMillis();
        setInCombat(true);
    }

    public void setCanReceiveDamage(boolean canReceiveDamage) {
        this.canReceiveDamage = canReceiveDamage;
    }

    private void setInCombat(boolean inCombat) {
        this.inCombat = inCombat;
        if(this.inCombat == false)
            entries.clear();
    }

    public List<CombatEntityEntry> getEntries() {
        return entries;
    }

    public Long getLastShot() {
        return lastShot;
    }

    public Long getLastHit() {
        return lastHit;
    }

    public boolean isInCombat() {
        return inCombat;
    }

    public boolean canReceiveDamage() {
        return canReceiveDamage;
    }

    public UUID getUuid() {
        return uuid;
    }

}
