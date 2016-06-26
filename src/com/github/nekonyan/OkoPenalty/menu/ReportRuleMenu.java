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

public class ReportRuleMenu implements Listener{
	
	
	
	  public static Inventory Rulereport = Bukkit.getServer().createInventory(null, 9, "Report理由選択");

	  static
	  {
	    ArrayList<String> a = new ArrayList<>();
	    a.add(ChatColor.WHITE + "ゲーム中の途中抜け（３回以上）");
	    createButton(Material.STICK, Rulereport, 0, ChatColor.RED + "途中抜け（３回以上）", a);
	    
	    ArrayList<String> b = new ArrayList<>();

	    b.add(ChatColor.WHITE + "ロビー以外での放置（５分以上）");
	    createButton(Material.COMPASS, Rulereport, 1, ChatColor.AQUA + "放置（５分以上）", b);
	    
	    ArrayList<String> c = new ArrayList<>();
	    c.add(ChatColor.WHITE + "使用が許可されていないMOD、外部ツールを利用する行為。");
	    createButton(Material.BLAZE_ROD, Rulereport, 2, ChatColor.GOLD + "MOD、外部ツールに関する違反", c);
	    
	    ArrayList<String> e = new ArrayList<>();
	    createButton(Material.WOOD_DOOR, Rulereport, 8, ChatColor.GREEN + "前の画面に戻る", e);
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
	    p.openInventory(Rulereport);
	  }
	  
	  @EventHandler
	  public void onClickInv2(InventoryClickEvent e) throws IOException {
		  if(Daisuke.instance.ReportRuleMenu){
	    Player p = (Player)e.getWhoClicked();
	    ItemStack clicked = e.getCurrentItem();
	    Inventory inv = e.getInventory();
	    if ((inv.getName().equals(Rulereport.getName())) && 
	      (clicked.getType() == Material.STICK)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("途中抜け（３回以上）");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportRuleMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Rulereport.getName())) && 
	      (clicked.getType() == Material.COMPASS)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("放置（５分以上）");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportRuleMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Rulereport.getName())) && 
	      (clicked.getType() == Material.BLAZE_ROD)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("MOD、外部ツールに関する違反");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportRuleMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Rulereport.getName())) && 
	      (clicked.getType() == Material.NETHER_STAR)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Daisuke.instance.ReportRuleMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Rulereport.getName())) && (clicked.getType() == Material.WOOD_DOOR)){
		      e.setCancelled(true);
		      p.closeInventory();
		      ReportmainMenu.openReportMenu(p);
		      Daisuke.instance.ReportRuleMenu = false;
		      Daisuke.instance.ReportmainMenu = true;
		      
	    }
		  }
	  }
}
