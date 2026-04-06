package org.tehcraftsmp.testingAdvancements.advancements.advs.tab;

import com.fren_gor.ultimateAdvancementAPI.AdvancementTab;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import org.bukkit.Material;
import org.tehcraftsmp.testingAdvancements.advancements.advs.AdvancementTabNamespaces;
import org.tehcraftsmp.testingAdvancements.advancements.advs.EasyRootAdvancement;

public class Root extends EasyRootAdvancement {

    public static final AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.tab_NAMESPACE, "beginning");

    public Root(AdvancementTab tab, CoordAdapter coords, String backgroundTexture) {
        super(tab, KEY, 1, coords, Material.OAK_SAPLING, "The Beginning", AdvancementFrameType.CHALLENGE, backgroundTexture,
                "", "The art of creating custom advancements.");
    }
}
