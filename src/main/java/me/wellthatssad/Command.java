package me.wellthatssad;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Console can't use this command :(");
            return true;
        }
        Player player = (Player) sender;
        TextComponent message = new TextComponent(Main.getInstance().getConfig().getString("Message"));
        message.setColor(ChatColor.AQUA);
        message.setBold(true);
        String HoverMessage = Main.getInstance().getConfig().getString("Message");
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(HoverMessage).color(ChatColor.LIGHT_PURPLE).bold(true).create()));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Main.getInstance().getConfig().getString("Url")));
        player.spigot().sendMessage(message);
        return true;
    }
}
