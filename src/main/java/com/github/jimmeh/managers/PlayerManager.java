package com.github.jimmeh.managers;

import com.github.jimmeh.entity.EntityInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class PlayerManager {

    private List<EntityInfo> entityInfos = new ArrayList<>();

    public void addEntity(UUID uuid){
        if(!doesEntityExist(uuid)){
            entityInfos.add(new EntityInfo(uuid));
        }
    }

    public void removeEntity(UUID uuid){
        EntityInfo remove = findEntity(uuid);
        if(remove != null){
            entityInfos.remove(remove);
        }
    }

    public EntityInfo findEntity(UUID uuid){
        for(EntityInfo entityInfo: entityInfos){
            if(entityInfo.getUuid().equals(uuid))
                return entityInfo;
        }
        return null;
    }

    public boolean doesEntityExist(UUID uuid){
        for(EntityInfo entityInfo: entityInfos){
            if(entityInfo.getUuid().equals(uuid))
                return true;
        }
        return false;
    }

    public void tick() {
        for(EntityInfo entityInfo: entityInfos){
            entityInfo.tickInCombat();
        }
    }
}
