package org.tehcraftsmp.testingAdvancements.advancements.advs.tab;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import com.fren_gor.ultimateAdvancementAPI.visibilities.ParentGrantedVisibility;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.tehcraftsmp.testingAdvancements.advancements.advs.AdvancementTabNamespaces;
import org.tehcraftsmp.testingAdvancements.advancements.advs.EasyAdvancement;

public class Chat_2 extends EasyAdvancement implements ParentGrantedVisibility, Listener {

    public static final AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.tab_NAMESPACE, "spammer");

    public Chat_2(Advancement parent, CoordAdapter coords) {
        super(parent, KEY, 10, coords, Material.AMETHYST_SHARD, "Spammer", AdvancementFrameType.TASK, "Send 10 chat messages.");
    }

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        this.incrementProgression(event.getPlayer(), 1);
    }
}
