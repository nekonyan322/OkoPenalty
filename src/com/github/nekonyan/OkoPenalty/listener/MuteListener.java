package com.github.nekonyan.OkoPenalty.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.github.nekonyan.OkoPenalty.Daisuke;
import com.github.nekonyan.OkoPenalty.commands.Mute;

public class MuteListener implements Listener{
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		if(Mute.mutedPlayers.contains(e.getPlayer().getName())){
			e.setCancelled(true);
			e.getPlayer().sendMessage(Daisuke.prefix + "現在、あなたはミュートされているためチャットができません。");
		}
	}
}
