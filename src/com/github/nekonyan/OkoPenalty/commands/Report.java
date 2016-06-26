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
import com.github.nekonyan.OkoPenalty.menu.ReportmainMenu;

public class Report implements CommandExecutor{

	public static String reportplayer = null;
	public static String reason = null;
	public static String sender = null;
	public static String date = null;
	
	  public static void setPlayer(String name)
	  {
	    reportplayer = name;
	  }
	  
	  public static void setReason(String type){
		  reason = type;
	  }
	  
	  public static void setSender(String sender) {
		
		  Report.sender = sender;
	  }
	  
	  public static void setDate(String date) {
		  Report.date = date;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("report")){
			if(sender instanceof Player){
				if(args.length == 0){
					sender.sendMessage("/report <プレイヤー名>");
				}
				if(args.length == 1){
					setPlayer(args[0]);
					setSender(sender.getName());
				
					Player player = (Player)sender;
					Daisuke.instance.ReportmainMenu = true;
					ReportmainMenu.openReportMenu(player);
					int month;
					Calendar cal1 = Calendar.getInstance();
					int day = cal1.get(5);
					int year = cal1.get(1);
					month = cal1.get(2) + 1;
				    int hour = cal1.get(Calendar.HOUR_OF_DAY);
					int minute = cal1.get(12);
					int sc = cal1.get(13);
					String Date = year + "/" + month + "/" + day + " " + hour +":" + minute +":"+ sc;
					setDate(Date);

				}
			}
		}
		return false;
	}
	
	 public static void reportToStaff()
	  {
		 int nowreportby = MySQLManager.getWarmint(sender);
			int reportby = nowreportby + 1;
			MySQLManager.reportbyint(sender, reportby);
			MySQLManager.report(reportplayer, date, reason, sender);
	    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
	      if (player.getName() == Daisuke.instance.management1 || player.getName() == Daisuke.instance.management2 || player.getName() == Daisuke.instance.management3 || player.getName() == Daisuke.instance.management4 || player.getName() == Daisuke.instance.management5) {
	        player.sendMessage(ChatColor.RED + "Report" + ChatColor.GRAY + "> " + ChatColor.YELLOW + "レポートプレーヤー: " + ChatColor.WHITE + reportplayer + 
	          ChatColor.YELLOW + " 理由: " + ChatColor.WHITE + reason + " Sender: " + sender + " Date: " + date);
	      }
	    }
	  }
}
