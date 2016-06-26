package com.github.nekonyan.OkoPenalty;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.nekonyan.OkoPenalty.Util.FileManager;
import com.github.nekonyan.OkoPenalty.Util.MySQL;
import com.github.nekonyan.OkoPenalty.commands.Alert;
import com.github.nekonyan.OkoPenalty.commands.Freeze;
import com.github.nekonyan.OkoPenalty.commands.Mute;
import com.github.nekonyan.OkoPenalty.commands.Report;
import com.github.nekonyan.OkoPenalty.commands.Staffmenu;
import com.github.nekonyan.OkoPenalty.commands.Warm;
import com.github.nekonyan.OkoPenalty.listener.MuteListener;
import com.github.nekonyan.OkoPenalty.listener.Penaltylistener;
import com.github.nekonyan.OkoPenalty.menu.ReportChatMenu;
import com.github.nekonyan.OkoPenalty.menu.ReportGriefingmenu;
import com.github.nekonyan.OkoPenalty.menu.ReportHackcheatMenu;
import com.github.nekonyan.OkoPenalty.menu.ReportRuleMenu;
import com.github.nekonyan.OkoPenalty.menu.ReportmainMenu;
import com.github.nekonyan.OkoPenalty.menu.StaffMenu;

public class Daisuke extends JavaPlugin{
	
	public String management1 = null;
	public String management2 = null;
	public String management3 = null;
	public String management4 = null;
	public String management5 = null;
	
	public static String prefix = ChatColor.LIGHT_PURPLE + "OkoPenalty" + ChatColor.GRAY + "> " + ChatColor.RESET;
	public static Daisuke instance;
	public static Report report;
	
	public boolean ReportChatMenu = false;
	public boolean ReportmainMenu = false;
	public boolean ReportHackcheatMenu = false;
	public boolean ReportGriefingmenu = false;
	public boolean ReportRuleMenu = false;
	public int tick = 0;
	public static int timer = 0;
	
	public void tick(){
		tick++;
		if(tick % 20 == 0){
			timer();
		}
		if(tick % 5 == 0){
			for(@SuppressWarnings("unused") Player player : Bukkit.getOnlinePlayers()){
			}
		}
		if(tick == 1000){
			tick = 0;
		}
	}
	
	public void timer(){
		if( Bukkit.getOnlinePlayers().size() < 5){

			
		}
		
	}	
	
	
	@Override
	public void onEnable() {
		instance = this;
		FileManager.setStanderdMySQL();
		FileManager.readMySQL();	
		FileManager.setStanderdConfig();
		FileManager.readConfig();
		registerCmds();
		registerEvents();
		MySQL.Connect();
		MySQL.createTable();
	}
	
	@Override
	public void onDisable() {
	MySQL.Close();
	}

	private void registerCmds() {
		getCommand("warm").setExecutor(new Warm());
		getCommand("alert").setExecutor(new Alert());
		getCommand("mute").setExecutor(new Mute());
		getCommand("freeze").setExecutor(new Freeze());
		getCommand("report").setExecutor(new Report());
		getCommand("staffmenu").setExecutor(new Staffmenu());
		getCommand("s").setExecutor(new Staffmenu());
		getCommand("sm").setExecutor(new Staffmenu());
		getCommand("staff").setExecutor(new Staffmenu());
	}
	
	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new MuteListener(), this);
		pm.registerEvents(new Penaltylistener(), this);
		pm.registerEvents(new ReportmainMenu(), this);
		pm.registerEvents(new ReportHackcheatMenu(), this);
		pm.registerEvents(new ReportChatMenu(), this);
		pm.registerEvents(new ReportGriefingmenu(), this);
		pm.registerEvents(new ReportRuleMenu(), this);
		pm.registerEvents(new StaffMenu(), this);
	}
	
	public static Daisuke getInstance() {
		return instance;
	}
	
	public void runTask(){
		Bukkit.getServer().getScheduler().runTaskTimer(instance, new Runnable() {
			@Override
			public void run() {
				tick();
			}
		}, 1L, 1L);
	}


}
