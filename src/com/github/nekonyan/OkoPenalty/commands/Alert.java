package com.github.nekonyan.OkoPenalty.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.nekonyan.OkoPenalty.Daisuke;

public class Alert implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("alert")){
			if(!(sender instanceof Player)){
				sender.sendMessage(Daisuke.prefix + ChatColor.RED + "プレイヤーのみ実行可能です");
			}else{
				Player p = (Player)sender;
				if(!(p.getName() == Daisuke.instance.management1 || p.getName() == Daisuke.instance.management2 || p.getName() == Daisuke.instance.management3 || p.getName() == Daisuke.instance.management4 || p.getName() == Daisuke.instance.management5)){
					p.sendMessage(Daisuke.prefix + ChatColor.RED + "Unknown command. Type /help for help.");
				}else if (args.length == 0) {
					p.sendMessage(Daisuke.prefix + ChatColor.RED + "メッセージが空です。　/alert　<メッセージ>");
				}else {
					Bukkit.getServer().broadcastMessage("<" + ChatColor.RED + "Alert" + ChatColor.RESET +">" + ChatColor.RED + message(args));
				}
			}
		}
		return false;
	}
	

	public String message(String[] args){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < args.length; i++){
			builder.append(args[i]);
			builder.append(" ");
		}
		return builder.toString().trim();
	}
}
