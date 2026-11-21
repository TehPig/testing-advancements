package org.tehcraftsmp.testingAdvancements;

import com.fren_gor.ultimateAdvancementAPI.AdvancementMain;
import com.fren_gor.ultimateAdvancementAPI.AdvancementTab;
import com.fren_gor.ultimateAdvancementAPI.UltimateAdvancementAPI;
import com.fren_gor.ultimateAdvancementAPI.database.impl.SQLite;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import org.bukkit.plugin.java.JavaPlugin;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.tehcraftsmp.testingAdvancements.advancements.advs.AdvancementTabNamespaces;
import org.tehcraftsmp.testingAdvancements.advancements.advs.tab.*;
import org.tehcraftsmp.testingAdvancements.commands.AdvancementCommand;
import org.tehcraftsmp.testingAdvancements.events.PlayerJoin;
import org.tehcraftsmp.testingAdvancements.utils.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class TestingAdvancements extends JavaPlugin {

    private AdvancementMain main;
    private UltimateAdvancementAPI api;
    private static final List<Advancement> advancements = new ArrayList<>();

    public static List<Advancement> getAdvancements() {
        return advancements;
    }

    private boolean debugMode = false;

    @Override
    public void onLoad() {
        main = new AdvancementMain(this);
        main.load();
    }

    @Override
    public void onEnable() {
        main.enable(() -> new SQLite(main, new File(getDataFolder(), "database.db")));
        api = UltimateAdvancementAPI.getInstance(this);

        setupAdvancements();

        getServer().getPluginManager().registerEvents(new PlayerJoin(api), this);

        getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> event.registrar().register("testadv", "Main command for Testing Advancements", List.of("tadv"), new AdvancementCommand(api)));

        Logger.info("Plugin has been enabled successfully.");
    }

    @Override
    public void onDisable() {
        if (main != null) main.disable();
        Logger.info("Plugin has been disabled.");
    }

    public boolean isDebugMode() {return this.debugMode;    }

    /**
     * Builds the advancement hierarchy and defines visual relationships.
     */
    private void setupAdvancements() {
        CoordAdapter coords = createCoordAdapter();

        AdvancementTab tab = api.createAdvancementTab(AdvancementTabNamespaces.tab_NAMESPACE, "textures/block/mangrove_log.png");

        Root beginning = new Root(tab, coords, "textures/block/mangrove_log.png");

        // --- Wood Branch ---
        Wood_1 wood_1 = new Wood_1(beginning, coords);
        Wood_2 wood_2 = new Wood_2(wood_1, coords);
        Wood_3 wood_3 = new Wood_3(wood_2, coords);

        getServer().getPluginManager().registerEvents(wood_1, this);
        getServer().getPluginManager().registerEvents(wood_2, this);
        getServer().getPluginManager().registerEvents(wood_3, this);

        // --- Stone Branch ---
        Stone_1 stone_1 = new Stone_1(wood_1, coords);
        Stone_2 stone_2 = new Stone_2(stone_1, coords);

        getServer().getPluginManager().registerEvents(stone_1, this);
        getServer().getPluginManager().registerEvents(stone_2, this);

        // --- Communication Branch ---
        Chat chat = new Chat(beginning, coords);
        Chat_2 chat_2 = new Chat_2(chat, coords);
        Chat_3 chat_3 = new Chat_3(chat_2, coords);
        ChattyKathy chatty = new ChattyKathy(chat, coords);

        getServer().getPluginManager().registerEvents(chat, this);
        getServer().getPluginManager().registerEvents(chat_2, this);
        getServer().getPluginManager().registerEvents(chat_3, this);
        getServer().getPluginManager().registerEvents(chatty, this);

        // --- Combat Branch ---
        Sword_1 sword_1 = new Sword_1(wood_1, coords);
        Sword_2 sword_2 = new Sword_2(sword_1, coords);
        NotEvenClose notEvenClose = new NotEvenClose(sword_1, coords);

        getServer().getPluginManager().registerEvents(sword_1, this);
        getServer().getPluginManager().registerEvents(sword_2, this);
        getServer().getPluginManager().registerEvents(notEvenClose, this);

        // --- Misc Branch ---
        CactusHugger cactusHugger = new CactusHugger(beginning, coords);
        getServer().getPluginManager().registerEvents(cactusHugger, this);

        // --- Utility Branch ---
        Inventory inventory = new Inventory(beginning, coords);
        Craft craft = new Craft(inventory, coords);

        getServer().getPluginManager().registerEvents(inventory, this);
        getServer().getPluginManager().registerEvents(craft, this);

        tab.registerAdvancements(beginning, wood_1, wood_2, wood_3, stone_1, stone_2, chat, chat_2, chat_3, chatty, sword_1, sword_2, notEvenClose, cactusHugger, inventory, craft);
        tab.automaticallyGrantRootAdvancement();

        // Keep track of all advancements for manual reset
        advancements.clear();
        advancements.add(beginning);
        advancements.add(wood_1);
        advancements.add(wood_2);
        advancements.add(wood_3);
        advancements.add(stone_1);
        advancements.add(stone_2);
        advancements.add(chat);
        advancements.add(chat_2);
        advancements.add(chat_3);
        advancements.add(chatty);
        advancements.add(sword_1);
        advancements.add(sword_2);
        advancements.add(notEvenClose);
        advancements.add(cactusHugger);
        advancements.add(inventory);
        advancements.add(craft);
    }

    private CoordAdapter createCoordAdapter() {
        return CoordAdapter.builder().add(Root.KEY, 0f, 0f).add(Inventory.KEY, -2f, 0f).add(Craft.KEY, -3f, 0f).add(Chat.KEY, 1f, -2f).add(Chat_2.KEY, 2f, -2f).add(Chat_3.KEY, 3f, -2f).add(ChattyKathy.KEY, 2f, -3f).add(Wood_1.KEY, 2f, 0f).add(Wood_2.KEY, 3f, 0f).add(Wood_3.KEY, 4f, 0f).add(Stone_1.KEY, 3f, 1f).add(Stone_2.KEY, 4f, 1f).add(Sword_1.KEY, 2f, 3f).add(Sword_2.KEY, 3f, 3f).add(NotEvenClose.KEY, 3f, 4f).add(CactusHugger.KEY, 0f, 2f).build();
    }
}