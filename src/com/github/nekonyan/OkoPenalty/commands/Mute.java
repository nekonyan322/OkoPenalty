package com.github.nekonyan.OkoPenalty.commands;

import java.util.ArrayList;
import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.nekonyan.OkoPenalty.Daisuke;
import com.github.nekonyan.OkoPenalty.manager.MySQLManager;

public class Mute implements CommandExecutor{
	
	public static ArrayList<String> mutedPlayers = new ArrayList<>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("mute")){
			if(!(sender.getName() == Daisuke.instance.management1 || sender.getName() == Daisuke.instance.management2 || sender.getName() == Daisuke.instance.management3 || sender.getName() == Daisuke.instance.management4 || sender.getName() == Daisuke.instance.management5)){
				sender.sendMessage( "Unknown command. Type /help for help.");
			}else if (args.length == 0) {
				sender.sendMessage(Daisuke.prefix + "/mute <プレイヤー名>");				
			}else {
				Player p = Bukkit.getPlayer(args[0]);
				if(p == null){
					sender.sendMessage(Daisuke.prefix + "そのプレイヤーは存在しません");
				}else if (mutedPlayers.contains(p.getName())) {
				sender.sendMessage(Daisuke.prefix + p.getName() + "のミュートを解除しました");
				mutedPlayers.remove(p.getName());
				p.sendMessage(Daisuke.prefix + "あなたのミュートが解除されました");
				}
				else {
					int month;
					Calendar cal1 = Calendar.getInstance();
					int day = cal1.get(5);
					int year = cal1.get(1);
					month = cal1.get(2) + 1;
				    int hour = cal1.get(Calendar.HOUR_OF_DAY);
					int minute = cal1.get(12);
					int sc = cal1.get(13);
					String Date = year + "/" + month + "/" + day + " " + hour +":" + minute +":"+ sc;
					String playername = p.getName();
					String warmedby = sender.getName();
					sender.sendMessage(Daisuke.prefix + p.getName() + "をミュートにしました。");
					mutedPlayers.add(p.getName());
					p.sendMessage(Daisuke.prefix + "あなたをMuteしました、解除されるまでチャットができません。\n Muted by " + sender.getName() + "\n Date: " + Date);
					MySQLManager.mute(playername, Date, warmedby);
					int nowmuteint = MySQLManager.getMuteint(playername);
					int mute =  nowmuteint + 1;
					MySQLManager.muteint(playername, mute);
				}
			}
		}
		return false;
	}
}
