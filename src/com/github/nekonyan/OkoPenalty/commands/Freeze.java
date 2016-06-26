package com.github.nekonyan.OkoPenalty.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.nekonyan.OkoPenalty.Daisuke;
import com.github.nekonyan.OkoPenalty.manager.MySQLManager;

public class Freeze implements CommandExecutor{
	  public static ArrayList<String> frozenPlayers = new ArrayList<>();
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if (cmd.getName().equalsIgnoreCase("freeze")) {
	      if (sender.getName() == Daisuke.instance.management1 || sender.getName() == Daisuke.instance.management2 || sender.getName() == Daisuke.instance.management3 || sender.getName() == Daisuke.instance.management4 || sender.getName() == Daisuke.instance.management5)
	      {
	        if (args.length == 0) {
	          sender.sendMessage(Daisuke.prefix + "/freeze <プレイヤー�?>");
	        } else {
	            Player p = Bukkit.getPlayer(args[0]);
	            if (p == null)
	            {
	              sender.sendMessage(Daisuke.prefix + "そのプレイヤーは存在しません");
	            }
	            else if (frozenPlayers.contains(p.getName()))
	            {
	              sender.sendMessage(Daisuke.prefix + p.getName() + "のフリーズを解除しました");
	              frozenPlayers.remove(p.getName());
	              p.setWalkSpeed((float) 0.2);
	              p.removePotionEffect(PotionEffectType.JUMP);
	              p.sendMessage(Daisuke.prefix + "あなたのフリーズが解除されました�?");
	            }
	            else
	            {
	              sender.sendMessage(Daisuke.prefix + p.getName() + "をフリーズ状態にしました");
	              frozenPlayers.add(p.getName());
	              p.setWalkSpeed(0);
	              p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2147483647, -125));
	              p.sendMessage(Daisuke.prefix + "あなたをフリーズ状態にしました 。解除するまで動けません。\n" + "freezed by " + sender.getName());
	              int nowfreezeint = MySQLManager.getFreezeint(p.getName());
	              MySQLManager.freezeint(p.getName(), nowfreezeint + 1);
	            }
	          }
	        }
	      if(!(sender.getName() == Daisuke.instance.management1 || sender.getName() == Daisuke.instance.management2 || sender.getName() == Daisuke.instance.management3 || sender.getName() == Daisuke.instance.management4 || sender.getName() == Daisuke.instance.management5)){
	    	  sender.sendMessage("Unknown command. Type /help for help.");
	      }
	      }
	    return false;
	  }
}
