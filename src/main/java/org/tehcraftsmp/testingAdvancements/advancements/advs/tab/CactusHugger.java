package org.tehcraftsmp.testingAdvancements.advancements.advs.tab;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import com.fren_gor.ultimateAdvancementAPI.visibilities.ParentGrantedVisibility;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.tehcraftsmp.testingAdvancements.advancements.advs.AdvancementTabNamespaces;
import org.tehcraftsmp.testingAdvancements.advancements.advs.EasyAdvancement;

public class CactusHugger extends EasyAdvancement implements ParentGrantedVisibility, Listener {

    public static final AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.tab_NAMESPACE, "cactus_hugger");

    public CactusHugger(Advancement parent, CoordAdapter coords) {
        super(parent, KEY, 10, coords, Material.CACTUS, "Cactus Hugger", AdvancementFrameType.TASK, "Take damage from a cactus 10 times.", "Why would you do this?");
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player plr) {
            if (event.getCause() == EntityDamageEvent.DamageCause.CONTACT) this.incrementProgression(plr, 1);
        }
    }
}
