package org.tehcraftsmp.testingAdvancements.commands;

import com.fren_gor.ultimateAdvancementAPI.UltimateAdvancementAPI;
import com.fren_gor.ultimateAdvancementAPI.AdvancementTab;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.tehcraftsmp.testingAdvancements.TestingAdvancements;
import org.tehcraftsmp.testingAdvancements.advancements.advs.AdvancementTabNamespaces;

import java.util.Collection;
import java.util.Collections;

public class AdvancementCommand implements BasicCommand {

    private final UltimateAdvancementAPI api;

    public AdvancementCommand(UltimateAdvancementAPI api) {
        this.api = api;
    }

    @Override
    public void execute(@NotNull CommandSourceStack stack, @NotNull String[] args) {
        CommandSender sender = stack.getSender();
        
        if (!sender.hasPermission("testingadvancements.admin")) {
            sender.sendMessage("§cYou don't have permission to use this command.");
            return;
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("reset")) {
            Player target;
            if (args.length > 1) {
                target = Bukkit.getPlayer(args[1]);
                if (target == null) {
                    sender.sendMessage("§cPlayer not found.");
                    return;
                }
            } else {
                if (!(sender instanceof Player)) {
                    sender.sendMessage("§cPlease specify a player.");
                    return;
                }
                target = (Player) sender;
            }

            AdvancementTab tab = api.getAdvancementTab(AdvancementTabNamespaces.tab_NAMESPACE);
            if (tab != null) {
                // Efficiently revoke only the advancements the player actually has
                for (Advancement adv : TestingAdvancements.getAdvancements()) {
                    if (adv.isGranted(target)) adv.revoke(target);
                }
                
                // Show tab again and grant root to restart
                tab.showTab(target);
                tab.grantRootAdvancement(target);
                sender.sendMessage("§aReset all advancements for " + target.getName());
            } else {
                sender.sendMessage("§cAdvancement tab not found.");
            }
            return;
        }

        sender.sendMessage("§eUsage: /testadv reset [player]");
    }

    @Override
    public @NotNull Collection<String> suggest(@NotNull CommandSourceStack stack, @NotNull String[] args) {
        if (args.length == 1) return Collections.singletonList("reset");
        return Collections.emptyList();
    }
}
