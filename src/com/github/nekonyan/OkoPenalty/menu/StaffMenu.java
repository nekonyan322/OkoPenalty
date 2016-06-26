package com.github.nekonyan.OkoPenalty.menu;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.nekonyan.OkoPenalty.Daisuke;
import com.github.nekonyan.OkoPenalty.task.RestartTask;

public class StaffMenu implements Listener{
	
	public static boolean Fryb = false;
	public static boolean Invisi = false;
	public ArrayList<String> hiden = new ArrayList<String>();
	
	public static Inventory Staffmenu = Bukkit.getServer().createInventory(null, 27, "StaffMenu");
	
	static{
		ArrayList<String> none = new ArrayList<>();
		createButton(Material.STAINED_GLASS_PANE, Staffmenu, 0, "GameModeChenge ==>", none);
		createButton(Material.DIAMOND_SWORD, Staffmenu, 1, "CreativeMode", none);
		createButton(Material.IRON_SWORD, Staffmenu, 2, "SurvivalMode", none);
		createButton(Material.STONE_SWORD, Staffmenu, 3, "AdventureMode", none);
		createButton(Material.WOOD_SWORD, Staffmenu, 4, "SpectatorMode", none);
		createButton(Material.STAINED_GLASS_PANE, Staffmenu, 5, "serveroperate ==>", none);
		createButton(Material.SNOW_BALL, Staffmenu, 6, ChatColor.GREEN +"" + ChatColor.BOLD +"serverReload", none);
		createButton(Material.SLIME_BALL, Staffmenu, 7, ChatColor.RED +"" + ChatColor.BOLD + "serverRestart", none);		
		createButton(Material.STAINED_GLASS_PANE, Staffmenu, 9, "PlayerPenalty ==>", none);
		createButton(Material.IRON_BOOTS, Staffmenu, 19, ChatColor.GREEN +"" + ChatColor.BOLD +"Kick", none);
		createButton(Material.BOW, Staffmenu, 20, ChatColor.YELLOW +"" + ChatColor.BOLD + "TIMEBAN", none);
		createButton(Material.ARROW, Staffmenu, 21, ChatColor.YELLOW +"" + ChatColor.BOLD + "BAN", none);
		createButton(Material.STAINED_GLASS_PANE, Staffmenu, 18, "PlayerPenalty ==>", none);
		createButton(Material.BARRIER, Staffmenu, 10, ChatColor.GREEN +"" + ChatColor.BOLD +"MuteMenu", none);
		createButton(Material.PACKED_ICE, Staffmenu, 11, ChatColor.YELLOW +"" + ChatColor.BOLD +"FreezeMenu", none);
		createButton(Material.REDSTONE, Staffmenu, 12, ChatColor.RED +"" + ChatColor.BOLD + "WarmMenu", none);
		createButton(Material.BOOK_AND_QUILL, Staffmenu, 13, ChatColor.AQUA + "" + ChatColor.BOLD +"ReportLog", none);
		createButton(Material.STAINED_GLASS_PANE, Staffmenu, 22, "and More... ==>", none);
		ArrayList<String> Frytrue = new ArrayList<>();
		Frytrue.add(ChatColor.GREEN + "" + ChatColor.BOLD + "�?  Enable");
		createButton(Material.FEATHER, Staffmenu, 23, ChatColor.WHITE +"" + ChatColor.BOLD +"Fry", Frytrue);
		ArrayList<String> Fryfalse = new ArrayList<>();
		Fryfalse.add(ChatColor.RED + "" + ChatColor.BOLD + "�?  Disable");
		createButton(Material.LEATHER_BOOTS, Staffmenu, 24, ChatColor.WHITE +"" + ChatColor.BOLD +"Fry", Fryfalse);
		ArrayList<String> Invisivilitytrue = new ArrayList<>();
		Invisivilitytrue.add(ChatColor.GREEN + "" + ChatColor.BOLD + "�? Enable");
		createButton(Material.GLASS_BOTTLE, Staffmenu, 25, ChatColor.GRAY +"" + ChatColor.BOLD +"Invisivility", Invisivilitytrue);
		ArrayList<String> Invisivilityfalse = new ArrayList<>();
		Invisivilityfalse.add(ChatColor.RED + "" + ChatColor.BOLD + "�? Diasble");
		createButton(Material.POTION, Staffmenu, 26, ChatColor.GRAY +"" + ChatColor.BOLD +"Invisivility Cancel", Invisivilityfalse);
		
		
	}
	
	public static void createButton(Material material, Inventory inv, int Slot, String name, ArrayList<String> motd){
		ItemStack itemStack = new ItemStack(material);
		ItemMeta meta = itemStack.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(motd);
		itemStack.setItemMeta(meta);
		inv.setItem(Slot, itemStack);
	}

	public static void openStaffMenu(Player p){
		p.openInventory(Staffmenu);
		}
	  @EventHandler
	  public void onClickInv(InventoryClickEvent e) throws IOException {
		  Player p = (Player)e.getWhoClicked();
		  ItemStack clicked = e.getCurrentItem();
		  Inventory inv = e.getInventory();
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.FEATHER)){
			  e.setCancelled(true);
			  p.setAllowFlight(true);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.LEATHER_BOOTS)){
			  e.setCancelled(true);
			  p.setAllowFlight(false);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.GLASS_BOTTLE)){
			  e.setCancelled(true);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.POTION)){
			  e.setCancelled(true);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.DIAMOND_SWORD)){
			  e.setCancelled(true);
			  p.setGameMode(GameMode.CREATIVE);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.IRON_SWORD)){
			  e.setCancelled(true);
			  p.setGameMode(GameMode.SURVIVAL);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.STONE_SWORD)){
			  e.setCancelled(true);
			  p.setGameMode(GameMode.ADVENTURE);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.WOOD_SWORD)){
			  e.setCancelled(true);
			  p.setGameMode(GameMode.SPECTATOR);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.STAINED_GLASS_PANE)){
			  e.setCancelled(true);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.SLIME_BALL)){
			  e.setCancelled(true);
			  new RestartTask().runTaskTimer(Daisuke.instance, 0, 20);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.SNOW_BALL)){
			  e.setCancelled(true);
			  Bukkit.broadcastMessage(ChatColor.GRAY +"" + ChatColor.ITALIC +  "[STAFF:" +ChatColor.RESET + ChatColor.RED +" Please note that this command is not supported and may cause issues when using some plugins." + ChatColor.GRAY +"" + ChatColor.ITALIC +   "]\n"
			  						+ "[STAFF:"+ChatColor.RED+" If you encounter any issues please use the /stop command to restart your server." +ChatColor.GRAY +"" + ChatColor.ITALIC +    "]" + ChatColor.RESET);
			  Bukkit.reload();
			  Bukkit.broadcastMessage(ChatColor.GRAY +"" + ChatColor.ITALIC +   "[STAFF:" +ChatColor.RESET +  ChatColor.GREEN + " Reload complete." + ChatColor.GRAY +"" + ChatColor.ITALIC +  "]" + ChatColor.RESET);
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.GLASS_BOTTLE)){
			  e.setCancelled(true);
			  for(Player player :Bukkit.getServer().getOnlinePlayers()){
				  if(player != p){
					  player.hidePlayer(p);
						}
				  }
			  p.closeInventory();
		  }
		  if ((inv.getName().equals(Staffmenu.getName())) && (clicked.getType() == Material.POTION)){
			  e.setCancelled(true);
			  for(Player player :Bukkit.getServer().getOnlinePlayers()){
				  if(player != p){
					  player.showPlayer(p);
						}
				  }
			  p.closeInventory();
		  }
		  
		  
		  
	  }
}
