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

public class Stone_1 extends EasyAdvancement implements ParentGrantedVisibility, Listener {

  public static final AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.tab_NAMESPACE, "stone_1");

  public Stone_1(Advancement parent, CoordAdapter coords) {
    super(parent, KEY, 32, coords, Material.COBBLESTONE_SLAB, "Stone Age v2", AdvancementFrameType.TASK, "Get 32 cobblestone.");
  }

  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    Material type = event.getBlock().getType();
    if (type == Material.STONE || type == Material.COBBLESTONE || type == Material.DEEPSLATE) {
        this.incrementProgression(event.getPlayer(), 1);
    }
  }
}
