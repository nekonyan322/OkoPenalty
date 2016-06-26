package com.github.nekonyan.OkoPenalty.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.github.nekonyan.OkoPenalty.manager.MySQLManager;

public class Penaltylistener implements Listener{

	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		String name = e.getPlayer().getName();
		MySQLManager.createPlayer(name);
		
	}
}
