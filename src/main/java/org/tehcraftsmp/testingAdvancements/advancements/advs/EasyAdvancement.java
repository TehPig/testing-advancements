package org.tehcraftsmp.testingAdvancements.advancements.advs;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplayBuilder;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public abstract class EasyAdvancement extends BaseAdvancement {

    public EasyAdvancement(@NotNull Advancement parent, @NotNull AdvancementKey key, int maxProgression,
                           @NotNull CoordAdapter coords, @NotNull Material icon, @NotNull String title,
                           @NotNull AdvancementFrameType frame, String... description) {
        super(parent, key.getKey(), maxProgression, new AdvancementDisplayBuilder(icon, title)
                .frame(frame)
                .coords(coords, key)
                .showToast()
                .announceChat()
                .description(description)
                .build());
    }
}
