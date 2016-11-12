package com.github.jimmeh.managers;

import com.github.jimmeh.CombatLogAPI;
import com.github.jimmeh.entity.EntityInfo;
import com.github.jimmeh.entries.CombatEntry;

import java.util.UUID;

public class CombatManager {

    /*
     * Add method to go through the combat entries once entity has died and determine who did what percentage
     */

    public void damageEntity(UUID victim, CombatEntry entry){
        //go through all info's entries, find match of entry's owner, if not make new entrycontainer, add entry
        EntityInfo entityInfo;

        if(!CombatLogAPI.getInstance().getPlayerManager().doesEntityExist(victim)){
            CombatLogAPI.getInstance().getPlayerManager().addEntity(victim);
        }
        entityInfo = CombatLogAPI.getInstance().getPlayerManager().findEntity(victim);

        if(!entityInfo.hasEntryContainer(entry.getOwner())){
            entityInfo.addEntryContainer(entry.getOwner());
        }

        entityInfo.addEntry(entry);
    }

}
