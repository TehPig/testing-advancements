package org.tehcraftsmp.testingAdvancements.events;

import com.fren_gor.ultimateAdvancementAPI.AdvancementTab;
import com.fren_gor.ultimateAdvancementAPI.UltimateAdvancementAPI;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    public final UltimateAdvancementAPI api;

    public PlayerJoin(UltimateAdvancementAPI api) {
        this.api = api;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent player) {
        Player plr = player.getPlayer();

        AdvancementTab tab = api.getAdvancementTab("tab");
        if (tab != null){
            tab.showTab(plr);
            tab.grantRootAdvancement(plr);
        }

        player.joinMessage(Component.text("Welcome to the server, " + plr.getName() + "!"));
    }

}
