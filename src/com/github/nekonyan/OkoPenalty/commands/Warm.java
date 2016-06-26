package com.github.nekonyan.OkoPenalty.commands;

import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.nekonyan.OkoPenalty.Daisuke;
import com.github.nekonyan.OkoPenalty.manager.MySQLManager;

public class Warm implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("warm")){
			if(!(sender instanceof Player)){
				sender.sendMessage(Daisuke.prefix + ChatColor.RED + "プレイヤーのみ実行可能です。");
			}else{
				Player p = (Player)sender;
				if(!(sender.getName() == Daisuke.instance.management1 || sender.getName() == Daisuke.instance.management2 || sender.getName() == Daisuke.instance.management3 || sender.getName() == Daisuke.instance.management4 || sender.getName() == Daisuke.instance.management5)){
					p.sendMessage(Daisuke.prefix + ChatColor.RED + "Unknown command. Type /help for help.");
				}else if (args.length == 1){
					p.sendMessage("プレイヤーの名前もしくは、理由がありません");	
				}else if (args.length == 0){
					p.sendMessage(Daisuke.prefix + ChatColor.RED + "/warm [プレイヤー名] [警告内容]");
				}else{
					int month;
					Calendar cal1 = Calendar.getInstance();
					int day = cal1.get(5);
					int year = cal1.get(1);
					month = cal1.get(2) + 1;
				    int hour = cal1.get(Calendar.HOUR_OF_DAY);
					int minute = cal1.get(12);
					int sc = cal1.get(13);
					String Date = year + "/" + month + "/" + day + " " + hour +":" + minute +":"+ sc;
					String playername = args[0];
					String reason= args[1];
					String warmedby = sender.getName();
					Player warmplayer = getPlayername(playername);
					MySQLManager.warm(playername, Date, reason, warmedby);
					warmplayer.sendMessage(ChatColor.RED + "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■警告■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					warmplayer.sendMessage(ChatColor.RED + "あなたは運営により警告されました。");
					warmplayer.sendMessage(ChatColor.RED + "理由: " + reason);
					warmplayer.sendMessage(ChatColor.RED + "一定回数警告されると、一定期間BANされる可能性があります。");
					warmplayer.sendMessage(ChatColor.RED + "警告した運営:  " + warmedby);
					warmplayer.sendMessage(ChatColor.RED + "警告された日付: " + Date);
					warmplayer.sendMessage(ChatColor.RED + "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					int nowwarmint = MySQLManager.getWarmint(playername);
					int warmint = nowwarmint + 1;
					MySQLManager.warmint(playername, warmint);
				}
			}
		}
		return false;
	}
	
	private Player getPlayername(String playername) {
		return Bukkit.getPlayer(playername);
	}

}
