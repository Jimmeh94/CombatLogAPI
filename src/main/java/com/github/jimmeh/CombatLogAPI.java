package com.github.jimmeh;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "combatlogapi", name = "CombatLogAPI", version = "1.0.0")
public class CombatLogAPI {

    private static CombatLogAPI instace;

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameInitializationEvent event){
        instace = this;
    }

    @Listener
    public void onServerStop(GameStoppedServerEvent event){
        //stuff
    }

    public static CombatLogAPI getInstace() {
        return instace;
    }

    public Logger getLogger() {
        return logger;
    }
}
