package com.github.nekonyan.OkoPenalty.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.nekonyan.OkoPenalty.Daisuke;
import com.github.nekonyan.OkoPenalty.menu.StaffMenu;

public class Staffmenu implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("staffmenu")) {
			if (sender.getName() == Daisuke.instance.management1 || sender.getName() == Daisuke.instance.management2 || sender.getName() == Daisuke.instance.management3 || sender.getName() == Daisuke.instance.management4 || sender.getName() == Daisuke.instance.management5){
				Player player = (Player)sender;
				StaffMenu.openStaffMenu(player);
			}
			else{
				sender.sendMessage("Unknown command. Type /help for help.");
			}
		}
		if (cmd.getName().equalsIgnoreCase("s")) {
			if (sender.getName() == Daisuke.instance.management1 || sender.getName() == Daisuke.instance.management2 || sender.getName() == Daisuke.instance.management3 || sender.getName() == Daisuke.instance.management4 || sender.getName() == Daisuke.instance.management5){
				Player player = (Player)sender;
				StaffMenu.openStaffMenu(player);
			}
			else{
				sender.sendMessage("Unknown command. Type /help for help.");
			}
		}
		if (cmd.getName().equalsIgnoreCase("staff")) {
			if (sender.getName() == Daisuke.instance.management1 || sender.getName() == Daisuke.instance.management2 || sender.getName() == Daisuke.instance.management3 || sender.getName() == Daisuke.instance.management4 || sender.getName() == Daisuke.instance.management5){
				Player player = (Player)sender;
				StaffMenu.openStaffMenu(player);
			}
			else{
				sender.sendMessage("Unknown command. Type /help for help.");
			}
		}
		if (cmd.getName().equalsIgnoreCase("sm")) {
			if (sender.getName() == Daisuke.instance.management1 || sender.getName() == Daisuke.instance.management2 || sender.getName() == Daisuke.instance.management3 || sender.getName() == Daisuke.instance.management4 || sender.getName() == Daisuke.instance.management5){
				Player player = (Player)sender;
				StaffMenu.openStaffMenu(player);
			}
			else{
				sender.sendMessage("Unknown command. Type /help for help.");
			}
		}
		
		return false;
	}
}
