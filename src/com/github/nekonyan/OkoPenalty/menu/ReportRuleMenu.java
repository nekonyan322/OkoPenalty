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
	
	
	
	  public static Inventory Rulereport = Bukkit.getServer().createInventory(null, 9, "Report���R�I��");

	  static
	  {
	    ArrayList<String> a = new ArrayList<>();
	    a.add(ChatColor.WHITE + "�Q�[�����̓r�������i�R��ȏ�j");
	    createButton(Material.STICK, Rulereport, 0, ChatColor.RED + "�r�������i�R��ȏ�j", a);
	    
	    ArrayList<String> b = new ArrayList<>();

	    b.add(ChatColor.WHITE + "���r�[�ȊO�ł̕��u�i�T���ȏ�j");
	    createButton(Material.COMPASS, Rulereport, 1, ChatColor.AQUA + "���u�i�T���ȏ�j", b);
	    
	    ArrayList<String> c = new ArrayList<>();
	    c.add(ChatColor.WHITE + "�g�p��������Ă��Ȃ�MOD�A�O���c�[���𗘗p����s�ׁB");
	    createButton(Material.BLAZE_ROD, Rulereport, 2, ChatColor.GOLD + "MOD�A�O���c�[���Ɋւ���ᔽ", c);
	    
	    ArrayList<String> e = new ArrayList<>();
	    createButton(Material.WOOD_DOOR, Rulereport, 8, ChatColor.GREEN + "�O�̉�ʂɖ߂�", e);
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
	      Report.setReason("�r�������i�R��ȏ�j");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportRuleMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Rulereport.getName())) && 
	      (clicked.getType() == Material.COMPASS)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("���u�i�T���ȏ�j");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportRuleMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Rulereport.getName())) && 
	      (clicked.getType() == Material.BLAZE_ROD)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("MOD�A�O���c�[���Ɋւ���ᔽ");
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
