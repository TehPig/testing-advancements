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

public class Sword_2 extends EasyAdvancement implements ParentGrantedVisibility, Listener {

  public static final AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.tab_NAMESPACE, "sword_2");

  public Sword_2(Advancement parent, CoordAdapter coords) {
    super(parent, KEY, 100, coords, Material.STONE_SWORD, "The Slayer", AdvancementFrameType.TASK, "Kill 100 monsters.");
  }

  @EventHandler
  public void onMobKill(EntityDeathEvent event) {
    if (event.getEntity() instanceof Monster && event.getEntity().getKiller() != null) {
      Player killer = event.getEntity().getKiller();
      this.incrementProgression(killer, 1);
    }
  }
}
