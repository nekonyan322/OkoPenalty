package com.github.nekonyan.OkoPenalty.menu;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.nekonyan.OkoPenalty.Daisuke;
import com.github.nekonyan.OkoPenalty.commands.Report;

public class ReportHackcheatMenu implements Listener{
		public static Inventory Hackreport = Bukkit.getServer().createInventory(null, 9, "Report�?由選�?");

	  static
	  {
	    ArrayList<String> a = new ArrayList<>();
	    a.add(ChatColor.WHITE + "X-Ray,radarの使用");
	    createButton(Material.EYE_OF_ENDER, Hackreport, 0, ChatColor.RED + "相手�?�位置がわかるようなHack及�?�Cheatの使用", a);
	    
	    
	    ArrayList<String> b = new ArrayList<>();
	    b.add(ChatColor.WHITE + "KillAuraやAIMBotの使用");
	    createButton(Material.IRON_SWORD, Hackreport, 1, ChatColor.AQUA + "相手が不利になるよ�?なHack及�?�Cheatの使用", b);
	    
	    ArrayList<String> e = new ArrayList<>();
	    e.add(ChatColor.WHITE + "FourcefieldやNoKnockbackの使用");
	    createButton(Material.DIAMOND_LEGGINGS, Hackreport, 2, ChatColor.AQUA + "自�?が有利になるよ�?なHack及�?�Cheatの使用", e);
	    
	    ArrayList<String> c = new ArrayList<>();
	    c.add(ChatColor.WHITE + "Movement,Fryの使用");
	    createButton(Material.DIAMOND_BOOTS, Hackreport, 3, ChatColor.GOLD + "移動に関するHack及�?�Cheatの使用", c);
	    

	    
	    ArrayList<String> f = new ArrayList<>();
	    createButton(Material.WOOD_DOOR, Hackreport, 8, ChatColor.GREEN + "前�?�画面に戻�?", f);
	  }
	  
	  public static void createButton(Material mat, Inventory inv, int Slot, String name, ArrayList<String> lore)
	  {
	    ItemStack item = new ItemStack(mat);
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName(name);
	    meta.setLore(lore);
	    item.setItemMeta(meta);
	    inv.setItem(Slot, item);
	  }
	  
	  public static void openReportMenu(Player p){
	    p.openInventory(Hackreport);
	  }
	  
	  @EventHandler
	  public void onClickInv2(InventoryClickEvent e) throws IOException {
		  if(Daisuke.instance.ReportHackcheatMenu){
	    Player p = (Player)e.getWhoClicked();
	    ItemStack clicked = e.getCurrentItem();
	    Inventory inv = e.getInventory();
	    if ((inv.getName().equals(Hackreport.getName())) && 
	      (clicked.getType() == Material.EYE_OF_ENDER)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("X-Ray,radarの使用");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportHackcheatMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Hackreport.getName())) && 
	      (clicked.getType() == Material.IRON_SWORD)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("KillAuraやAIMBotの使用");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportHackcheatMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Hackreport.getName())) && 
	  	      (clicked.getType() == Material.DIAMOND_LEGGINGS)){
	  	      e.setCancelled(true);
	  	      p.closeInventory();
		      Report.setReason("FourcefieldやNoKnockbackの使用");
		      Report.setSender(p.getName());
		      Report.reportToStaff();
	  	      Daisuke.instance.ReportHackcheatMenu = false;
	  	      return;
	  	    }
	    if ((inv.getName().equals(Hackreport.getName())) && 
	      (clicked.getType() == Material.DIAMOND_BOOTS)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("Movement,Fryの使用");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportHackcheatMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Hackreport.getName())) && 
	  	      (clicked.getType() == Material.WOOD_DOOR)){
	  	      e.setCancelled(true);
	  	      p.closeInventory();
	  	      Daisuke.instance.ReportHackcheatMenu = false;
	  	      Daisuke.instance.ReportmainMenu = true;
	  	      ReportmainMenu.openReportMenu(p);
	  	      return;
	  	    }
	  }
	  }
}
