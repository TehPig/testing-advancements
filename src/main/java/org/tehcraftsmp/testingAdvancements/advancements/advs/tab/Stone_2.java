package org.tehcraftsmp.testingAdvancements.advancements.advs.tab;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import com.fren_gor.ultimateAdvancementAPI.visibilities.ParentGrantedVisibility;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.tehcraftsmp.testingAdvancements.advancements.advs.AdvancementTabNamespaces;
import org.tehcraftsmp.testingAdvancements.advancements.advs.EasyAdvancement;

public class Stone_2 extends EasyAdvancement implements ParentGrantedVisibility, Listener {

  public static final AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.tab_NAMESPACE, "stone_2");

  public Stone_2(Advancement parent, CoordAdapter coords) {
    super(parent, KEY, 128, coords, Material.COBBLESTONE, "Cobblestone Retriever", AdvancementFrameType.TASK, "Mine 2x64 cobblestone.");
  }

  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    if (event.getBlock().getType() == Material.STONE) this.incrementProgression(event.getPlayer(), 1);
  }
}
