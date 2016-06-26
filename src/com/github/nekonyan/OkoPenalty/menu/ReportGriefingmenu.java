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

public class ReportGriefingmenu implements Listener{
	
	  public static Inventory Griefingreport = Bukkit.getServer().createInventory(null, 9, "Report���R�I��");

	  static
	  {
	    ArrayList<String> a = new ArrayList<>();
	    a.add(ChatColor.WHITE + "�`�[����̏ꍇ�́A�`�[�������o�[�ւ̖W�Q");
	    createButton(Material.IRON_PICKAXE, Griefingreport, 0, ChatColor.RED + "�`�[�������o�[�ւ̖W�Q", a);
	    
	    ArrayList<String> b = new ArrayList<>();

	    b.add(ChatColor.WHITE + "�l��̏ꍇ�́A���v���C���[�Ƃ̋���");
	    createButton(Material.IRON_AXE, Griefingreport, 1, ChatColor.AQUA + "���v���C���[�Ƃ̋��͍s��", b);
	    
	    
	    
	    ArrayList<String> e = new ArrayList<>();
	    createButton(Material.WOOD_DOOR, Griefingreport, 8, ChatColor.GREEN + "�O�̉�ʂɖ߂�", e);
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
	    p.openInventory(Griefingreport);
	  }
	  
	  @EventHandler
	  public void onClickInv(InventoryClickEvent e) throws IOException {
		  if(Daisuke.instance.ReportGriefingmenu){
	    Player p = (Player)e.getWhoClicked();
	    ItemStack clicked = e.getCurrentItem();
	    Inventory inv = e.getInventory();
	    if ((inv.getName().equals(Griefingreport.getName())) && 
	      (clicked.getType() == Material.IRON_PICKAXE)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("�`�[�������o�[�ւ̖W�Q");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportGriefingmenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Griefingreport.getName())) && 
	      (clicked.getType() == Material.IRON_AXE)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("���v���C���[�Ƃ̋��͍s��");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportGriefingmenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Griefingreport.getName())) && 
	  	      (clicked.getType() == Material.NETHER_STAR)){
	  	      e.setCancelled(true);
	  	      p.closeInventory();
	  	      Daisuke.instance.ReportGriefingmenu = false;
	  	      return;
	  	    }
	    if ((inv.getName().equals(Griefingreport.getName())) && (clicked.getType() == Material.WOOD_DOOR)){
		      e.setCancelled(true);
		      p.closeInventory();
		      ReportmainMenu.openReportMenu(p);
		      Daisuke.instance.ReportGriefingmenu = false;
		      Daisuke.instance.ReportmainMenu = true;
	    }
		  }
	  }
}
