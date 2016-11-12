package com.github.jimmeh;

import com.github.jimmeh.managers.CombatManager;
import com.github.jimmeh.managers.PlayerManager;
import com.github.jimmeh.runnables.CoreTimer;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.scheduler.Task;

@Plugin(id = "combatlogapi", name = "CombatLogAPI", version = "1.0.0")
public class CombatLogAPI {

    private static CombatLogAPI instance;
    private static int combatInterval = 5; //how many seconds out of combat needed to be switched to out of combat

    private PlayerManager playerManager = new PlayerManager();
    private CombatManager combatManager = new CombatManager();

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameInitializationEvent event){
        instance = this;

        Task.Builder taskBuilder = Sponge.getScheduler().createTaskBuilder();
        taskBuilder.execute(new CoreTimer()).intervalTicks(20L).submit(this);
    }

    @Listener
    public void onServerStop(GameStoppedServerEvent event){
        //stuff
    }

    public static void setCombatInterval(int combatInterval) {
        CombatLogAPI.combatInterval = combatInterval;
    }

    public static CombatLogAPI getInstance() {
        return instance;
    }

    public Logger getLogger() {
        return logger;
    }

    public static int getCombatInterval() {
        return combatInterval;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public CombatManager getCombatManager() {
        return combatManager;
    }
}
