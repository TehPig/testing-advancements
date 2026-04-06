package org.tehcraftsmp.testingAdvancements.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.tehcraftsmp.testingAdvancements.TestingAdvancements;

public class Logger {

    private static final Component BRAND = MiniMessage.miniMessage().deserialize("<red>Testing</red>");

    public static void init(TestingAdvancements plugin) {}

    public static void info(String message) {
        Bukkit.getConsoleSender().sendMessage(BRAND.append(Component.text(" - ", NamedTextColor.GRAY))
                .append(Component.text(message, NamedTextColor.WHITE)));
    }

    public static void warn(String message) {
        Bukkit.getConsoleSender().sendMessage(BRAND.append(Component.text(" - ", NamedTextColor.GRAY))
                .append(Component.text(message, NamedTextColor.YELLOW)));
    }

    public static void error(String message) {
        Bukkit.getConsoleSender().sendMessage(BRAND.append(Component.text(" - ", NamedTextColor.GRAY))
                .append(Component.text(message, NamedTextColor.RED)));
    }
//
//    public static void debug(String message) {
//        if (debugMode) {
//            Bukkit.getConsoleSender().sendMessage(BRAND.append(Component.text(" - ", NamedTextColor.GRAY))
//                    .append(Component.text("[DEBUG] ", NamedTextColor.GOLD))
//                    .append(Component.text(message, NamedTextColor.GRAY)));
//        }
//    }
}
