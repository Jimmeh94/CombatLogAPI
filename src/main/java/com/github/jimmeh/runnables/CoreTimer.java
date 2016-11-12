package com.github.jimmeh.runnables;

import com.github.jimmeh.CombatLogAPI;

public class CoreTimer implements Runnable {
    @Override
    public void run() {
        CombatLogAPI.getInstance().getPlayerManager().tick();
    }
}
