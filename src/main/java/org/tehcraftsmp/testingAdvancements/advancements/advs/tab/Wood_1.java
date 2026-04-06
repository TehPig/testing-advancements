package org.tehcraftsmp.testingAdvancements.advancements.advs.tab;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplayBuilder;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import com.fren_gor.ultimateAdvancementAPI.visibilities.ParentGrantedVisibility;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.tehcraftsmp.testingAdvancements.advancements.advs.AdvancementTabNamespaces;
import org.tehcraftsmp.testingAdvancements.advancements.advs.EasyAdvancement;

public class Wood_1 extends EasyAdvancement implements ParentGrantedVisibility, Listener {

    public static final AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.tab_NAMESPACE, "wood_1");

    public Wood_1(Advancement parent, CoordAdapter coords) {
        super(parent, KEY, 10, coords, Material.STICK, "Treechopper", AdvancementFrameType.GOAL, "Chop 10 wood logs.");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (Tag.LOGS.isTagged(event.getBlock().getType())) {
            this.incrementProgression(event.getPlayer(), 1);
        }
    }
}
