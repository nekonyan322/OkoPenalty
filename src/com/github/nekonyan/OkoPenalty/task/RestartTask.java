package com.github.nekonyan.OkoPenalty.task;

import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RestartTask extends BukkitRunnable{
	
	public Player player;
	public int tick;
	
	public RestartTask() {
		for (Player p : Bukkit.getOnlinePlayers()){
			this.player = p;
			this.tick = 10;
		}
	}
	
	@Override
	public void run(){
		tick--;
	if(tick == 0){
		 int month;
		Calendar cal1 = Calendar.getInstance();
	      int day = cal1.get(5);
	      int year = cal1.get(1);
	      month = cal1.get(2) + 1;
	      int minute = cal1.get(12);
	      int sc = cal1.get(13);
	      player.kickPlayer(ChatColor.RED + "《�?�起動�??" + year + "年" + month + "�?" + day + "日" + minute + "�?" + sc + "�?に再起動を実行しました");
	      Bukkit.shutdown();
	}else{
			player.sendMessage(ChatColor.YELLOW + "�?" + "再起動を"+ tick +"秒後に行いま�?" + ChatColor.YELLOW + "�?");
		}
	}
}
	
