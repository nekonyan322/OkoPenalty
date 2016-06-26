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

public class ReportChatMenu implements Listener{
	  public static Inventory Chatreport = Bukkit.getServer().createInventory(null, 9, "Report���R�I��");
	  static
	  {
	    ArrayList<String> a = new ArrayList<>();
	    a.add(ChatColor.WHITE + "�\�����排����ɂ�葊���������悤�Ȍ���");
	    createButton(Material.SUGAR_CANE, Chatreport, 0, ChatColor.RED + "�����������悤�Ȍ���", a);
	    
	    ArrayList<String> b = new ArrayList<>();

	    b.add(ChatColor.WHITE + "�`���b�g�̘A�����M���ɂ�鑼�v���C���[�ւ̖��f�s��");
	    createButton(Material.MAP, Chatreport, 1, ChatColor.AQUA + "�`���b�g�ɂ�鑼�v���C���[�ւ̖��f�s��", b);
	    
	    ArrayList<String> c = new ArrayList<>();
	    c.add(ChatColor.WHITE + "���̃T�[�o�[�̐�`��A���I��n���ɂ��錾��");
	    createButton(Material.BOOK_AND_QUILL, Chatreport, 2, ChatColor.GOLD + "��`�Ɋւ���ᔽ", c);
	    

	    ArrayList<String> e = new ArrayList<>();
	    createButton(Material.WOOD_DOOR, Chatreport, 8, ChatColor.GREEN + "�O�̉�ʂɖ߂�", e);
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
	    p.openInventory(Chatreport);
	  }
	  
	  @EventHandler
	  public void onClickInv2(InventoryClickEvent e) throws IOException {
		  if(Daisuke.instance.ReportChatMenu){
	    Player p = (Player)e.getWhoClicked();
	    ItemStack clicked = e.getCurrentItem();
	    Inventory inv = e.getInventory();
	    if ((inv.getName().equals(Chatreport.getName())) && 
	      (clicked.getType() == Material.SUGAR_CANE)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("�\�����排����ɂ�葊���������悤�Ȍ���");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportChatMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Chatreport.getName())) && 
	      (clicked.getType() == Material.MAP)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Report.setReason("�`���b�g�̘A�����M���ɂ�鑼�v���C���[�ւ̖��f�s��");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportChatMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Chatreport.getName())) && 
	      (clicked.getType() == Material.BOOK_AND_QUILL)){
	      e.setCancelled(true);
	      p.closeInventory();

	      Report.setReason("���̃T�[�o�[�̐�`��A���I��n���ɂ��錾��");
	      Report.setSender(p.getName());
	      Report.reportToStaff();
	      Daisuke.instance.ReportChatMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Chatreport.getName())) && 
	      (clicked.getType() == Material.NETHER_STAR)){
	      e.setCancelled(true);
	      p.closeInventory();
	      Daisuke.instance.ReportChatMenu = false;
	      return;
	    }
	    if ((inv.getName().equals(Chatreport.getName())) && (clicked.getType() == Material.WOOD_DOOR)){
		      e.setCancelled(true);
		      p.closeInventory();
		      ReportmainMenu.openReportMenu(p);
		      Daisuke.instance.ReportChatMenu = false;
		      Daisuke.instance.ReportmainMenu = true;
	    }
	  }
	  }
}
