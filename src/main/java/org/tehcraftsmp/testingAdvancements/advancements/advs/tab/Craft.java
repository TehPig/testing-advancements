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
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.tehcraftsmp.testingAdvancements.advancements.advs.AdvancementTabNamespaces;
import org.tehcraftsmp.testingAdvancements.advancements.advs.EasyAdvancement;

public class Craft extends EasyAdvancement implements ParentGrantedVisibility, Listener {

  public static final AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.tab_NAMESPACE, "craft");

  public Craft(Advancement parent, CoordAdapter coords) {
    super(parent, KEY, 1, coords, Material.CRAFTING_TABLE, "The art of Crafting", AdvancementFrameType.TASK, "Craft a crafting table.");
  }

  @EventHandler
  public void onCraft(CraftItemEvent event) {
    if (event.getWhoClicked() instanceof Player plr) {
      if (event.getRecipe().getResult().getType() == Material.CRAFTING_TABLE) this.grant(plr);
    }
  }

  @Override
  public void giveReward(Player player) {
    player.give(ItemStack.of(Material.CRAFTING_TABLE, 1));
  }
}
