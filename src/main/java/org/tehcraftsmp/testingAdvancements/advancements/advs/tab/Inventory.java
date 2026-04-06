package org.tehcraftsmp.testingAdvancements.advancements.advs.tab;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.tehcraftsmp.testingAdvancements.advancements.advs.AdvancementTabNamespaces;
import org.tehcraftsmp.testingAdvancements.advancements.advs.EasyAdvancement;
import org.tehcraftsmp.testingAdvancements.utils.Logger;

public class Inventory extends EasyAdvancement implements Listener {

    public static final AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.tab_NAMESPACE, "inventory");

    public Inventory(Advancement parent, CoordAdapter coords) {
        super(parent, KEY, 1, coords, Material.BOOK, "Taking Inventory", AdvancementFrameType.GOAL, "Open your inventory.");
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Logger.info("Player " + event.getPlayer().getName() + " has opened inventory.");
        if (event.getPlayer() instanceof Player plr) this.grant(plr);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getPlayer() instanceof Player plr) {
            InventoryCloseEvent.Reason reason = event.getReason();
            if (reason != InventoryCloseEvent.Reason.DISCONNECT && reason != InventoryCloseEvent.Reason.UNLOADED) {
                this.grant(plr);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player plr) this.grant(plr);
    }
}
