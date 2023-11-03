package net.fabricmc.example;

import btw.community.example.WorseThanWolves;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class ExamplePreLaunchInitializer implements PreLaunchEntrypoint {
    /**
     * Runs the PreLaunch entrypoint to register BTW-Addon.
     * Don't initialize anything else here, use
     * the method Initialize() in the Addon.
     */
    @Override
    public void onPreLaunch() {
        WorseThanWolves.getInstance();
    }
}
