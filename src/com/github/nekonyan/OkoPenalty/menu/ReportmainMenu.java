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

public class ReportmainMenu   implements Listener{
	  public static Inventory report = Bukkit.getServer().createInventory(null, 9, "Report�?由選�?");

	  static
	  {
	    ArrayList<String> a = new ArrayList<>();
	    a.add(ChatColor.WHITE + "Hack�?cheatの使用");
	    createButton(Material.DIAMOND_SWORD, report, 0, ChatColor.RED + "Hack" + ChatColor.GRAY + "/" + ChatColor.RED + "Cheat", a);
	    
	    ArrayList<String> b = new ArrayList<>();
	    b.add(ChatColor.WHITE + "暴�?�?誹謗中傷");
	    b.add(ChatColor.WHITE + "チャ�?ト�?�連続�?�信");
	    b.add(ChatColor.WHITE + "宣�?");
	    createButton(Material.PAPER, report, 1, ChatColor.AQUA + "ChatSpam(チャ�?トに関する違反)", b);
	    
	    
	    ArrayList<String> c = new ArrayList<>();
	    c.add(ChatColor.WHITE + "同チー�?メンバ�?�への妨害");
	    c.add(ChatColor.WHITE + "個人戦でのチ�?��?での行動");
	    createButton(Material.IRON_CHESTPLATE, report, 2, ChatColor.GOLD + "Griefing(ゲー�?中の違反)", c);
	    
	    ArrayList<String> d = new ArrayList<>();
	    d.add(ChatColor.WHITE + "試合中の無断�?出(3回以�?)");
	    d.add(ChatColor.WHITE + "長時間の放置(5�?以�?)");
	    createButton(Material.BOOK, report, 3, ChatColor.GREEN + "RuleViolation(ルールの違反)", d);
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
	    p.openInventory(report);
	  }
	  
	  @EventHandler
	  public void onClickInv(InventoryClickEvent e) throws IOException {
		  if(Daisuke.instance.ReportmainMenu){
	    Player p = (Player)e.getWhoClicked();
	    ItemStack clicked = e.getCurrentItem();
	    Inventory inv = e.getInventory();
	    if ((inv.getName().equals(report.getName())) && 
	      (clicked.getType() == Material.DIAMOND_SWORD)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Daisuke.instance.ReportmainMenu = false;
	      Daisuke.instance.ReportHackcheatMenu = true;
	      ReportHackcheatMenu.openReportMenu(p);
	      return;
	    }
	    if ((inv.getName().equals(report.getName())) && 
	      (clicked.getType() == Material.PAPER)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Daisuke.instance.ReportmainMenu = false;
	      Daisuke.instance.ReportChatMenu = true;
	      ReportChatMenu.openReportMenu(p);
	      return;
	    }
	    if ((inv.getName().equals(report.getName())) && 
	      (clicked.getType() == Material.IRON_CHESTPLATE)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Daisuke.instance.ReportmainMenu = false;
	      Daisuke.instance.ReportGriefingmenu = true;
	      ReportGriefingmenu.openReportMenu(p);
	      return;
	    }
	    if ((inv.getName().equals(report.getName())) && 
	      (clicked.getType() == Material.BOOK)){
	      e.setCancelled(true);
	      p.closeInventory();
	      ReportRuleMenu.openReportMenu(p);
	      Daisuke.instance.ReportmainMenu = false;
	      Daisuke.instance.ReportRuleMenu = true;
	      return;
	    }
	  }
	  }
}
