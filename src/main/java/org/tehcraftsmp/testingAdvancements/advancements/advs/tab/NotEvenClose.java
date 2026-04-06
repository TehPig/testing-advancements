package org.tehcraftsmp.testingAdvancements.advancements.advs.tab;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import com.fren_gor.ultimateAdvancementAPI.visibilities.ParentGrantedVisibility;
import org.bukkit.Material;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.tehcraftsmp.testingAdvancements.advancements.advs.AdvancementTabNamespaces;
import org.tehcraftsmp.testingAdvancements.advancements.advs.EasyAdvancement;

public class NotEvenClose extends EasyAdvancement implements ParentGrantedVisibility, Listener {

    public static final AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.tab_NAMESPACE, "not_even_close");

    public NotEvenClose(Advancement parent, CoordAdapter coords) {
        super(parent, KEY, 1, coords, Material.GHAST_TEAR, "Not Even Close!", AdvancementFrameType.CHALLENGE, "Kill a monster while you are at half a heart.");
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent event) {
        if (event.getEntity() instanceof Monster && event.getEntity().getKiller() != null) {
            Player killer = event.getEntity().getKiller();
            if (killer.getHealth() <= 1.0) this.grant(killer);
        }
    }
}
