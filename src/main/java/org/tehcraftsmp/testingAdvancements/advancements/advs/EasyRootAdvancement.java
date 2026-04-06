package org.tehcraftsmp.testingAdvancements.advancements.advs;

import com.fren_gor.ultimateAdvancementAPI.AdvancementTab;
import com.fren_gor.ultimateAdvancementAPI.advancement.RootAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplayBuilder;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public abstract class EasyRootAdvancement extends RootAdvancement {

    public EasyRootAdvancement(@NotNull AdvancementTab tab, @NotNull AdvancementKey key, int maxProgression,
                               @NotNull CoordAdapter coords, @NotNull Material icon, @NotNull String title,
                               @NotNull AdvancementFrameType frame, @NotNull String backgroundTexture, String... description) {
        super(tab, key.getKey(), maxProgression, new AdvancementDisplayBuilder(icon, title)
                .frame(frame)
                .coords(coords, key)
                .showToast()
                .announceChat()
                .description(description)
                .build());
    }
}
