package com.github.nekonyan.OkoPenalty.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.nekonyan.OkoPenalty.Util.MySQL;

public class MySQLManager {
	
	public static void warm(String playername, String Date, String reason, String warmedby){
		
		MySQL.update("INSERT INTO warm (NAME, DATE, REASON, WARMEDBY) VALUES ('" + playername +"','" + Date + "','" +reason+"','" + warmedby + "')");
	}
	
	public static void mute(String playername, String Date, String warmedby){
		
		MySQL.update("INSERT INTO mute (NAME, DATE, WARMEDBY) VALUES ('" + playername +"','" + Date + "','" + warmedby + "')");
	}
	
	public static void freeze(String playername, String Date, String freezedby){
		
		MySQL.update("INSERT INTO freeze (NAME, DATE, FREEZEDBY) VALUES ('" + playername +"','" + Date + "','" + freezedby + "')");
	}
	
	public static void report(String playername, String Date, String reason, String reportedby){
		
		MySQL.update("INSERT INTO report (NAME, DATE, REASON, REPORTEDBY) VALUES ('" + playername +"','" + Date + "','" +reason+"','" + reportedby + "')");
	}
	
	
	
	public static void warmint(String playername, int warmint){
		
		MySQL.update("UPDATE penalty SET WARM = '" + warmint + "' WHERE NAME= '" + playername + "';");
	}
	public static void muteint(String playername, int muteint){
		
		MySQL.update("UPDATE penalty SET MUTE = '" + muteint + "' WHERE NAME= '" + playername + "';");
	}
	public static void freezeint(String playername, int freezeint){
		
		MySQL.update("UPDATE penalty SET FREEZE = '" + freezeint + "' WHERE NAME= '" + playername + "';");
	}
	public static void reportint(String playername, int reportint){
		
		MySQL.update("UPDATE penalty SET REPORT = '" + reportint + "' WHERE NAME= '" + playername + "';");
	}
	public static void reportbyint(String playername, int reportbyint){
		
		MySQL.update("UPDATE penalty SET REPORTBY = '" + reportbyint + "' WHERE NAME= '" + playername + "';");
	}
	

	  public static boolean playere(String name)
	  {
	    try
	    {
	      ResultSet rs = MySQL.getResult("SELECT * FROM penalty WHERE NAME= '" + name + "'");
	      if (rs.next()) {
	        return rs.getString("NAME") != null;
	      }
	      return false;
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	    }
	    return false;
	  }
	  
	  public static void createPlayer(String name)
	  {
	    if (!playere(name))
	    {
	      MySQL.update("INSERT INTO penalty(NAME ,WARM ,MUTE, FREEZE, REPORT, REPORTBY) VALUES ('" + name + "','0','0','0','0','0');");
	    }
	  }
	
	public static String iswarmed(String playername) {
		ResultSet rs = MySQL.getResult("SELECT * FROM warm WHERE NAME='" + playername + "'");
		try {
			while (rs.next()){
				return "‚ ‚é";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "‚È‚¢";
	}
	public static String getDate(String name){
	ResultSet rs = MySQL.getResult("SELECT * FROM warm WHERE NAME='" + name + "'");
	try {
		while (rs.next()){
			return rs.getString("DATE");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return "Unknown";
	}
	
	public static int getMuteint(String name){
	ResultSet rs = MySQL.getResult("SELECT * FROM penalty WHERE NAME='" + name + "'");
	try {
		while (rs.next()){
			return rs.getInt("MUTE");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
	}
	
	public static int getFreezeint(String name){
	ResultSet rs = MySQL.getResult("SELECT * FROM penalty WHERE NAME='" + name + "'");
	try {
		while (rs.next()){
			return rs.getInt("FREEZE");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
	}
	
	public static int getReportint(String name){
	ResultSet rs = MySQL.getResult("SELECT * FROM penalty WHERE NAME='" + name + "'");
	try {
		while (rs.next()){
			return rs.getInt("REPORT");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
	}
	
	public static int getReportbyint(String name){
	ResultSet rs = MySQL.getResult("SELECT * FROM penalty WHERE NAME='" + name + "'");
	try {
		while (rs.next()){
			return rs.getInt("REPORTBY");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
	}
	
	public static int getWarmint(String name){
	ResultSet rs = MySQL.getResult("SELECT * FROM penalty WHERE NAME='" + name + "'");
	try {
		while (rs.next()){
			return rs.getInt("WARM");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
	}
	
	public static String getReason(String name) {
		ResultSet rs = MySQL.getResult("SELECT * FROM warm WHERE NAME='" + name + "'");
		try {
			while (rs.next()){
				return rs.getString("REASON");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
