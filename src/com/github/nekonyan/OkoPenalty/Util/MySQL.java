package com.github.nekonyan.OkoPenalty.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import com.github.nekonyan.OkoPenalty.Daisuke;

public class MySQL {
	
	public static String username;
	public static String password;
	public static String database;
	public static String host;
	public static String port;
	public static Connection con;
	
	public static void Connect(){
		if(!isConnected()){
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database /*+ "?autoReconnect"*/, username ,password);
				Bukkit.getConsoleSender().sendMessage(Daisuke.prefix + "MySQLÇ∆ê⁄ë±ÇµÇ‹ÇµÇΩÅB");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void Close(){
		if(isConnected()){
			try {
				con.close();
					Bukkit.getConsoleSender().sendMessage(Daisuke.prefix + "MySQLÇ∆ÇÃê⁄ë±ÇèIóπÇµÇ‹ÇµÇΩÅB");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		
	}
	
	public static boolean isConnected(){

		return con != null;
	}
	
	public static void createTable(){
		if(isConnected()){

			try {
				con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS warm(ID int(11) AUTO_INCREMENT , NAME varchar(64), DATE varchar(64), REASON varchar(120), WARMEDBY varchar(64), PRIMARY KEY (`ID`));");
				con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS report(ID int(11) AUTO_INCREMENT , NAME varchar(64), DATE varchar(64), REASON varchar(120), REPORTEDBY varchar(64), PRIMARY KEY (`ID`));");
				con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS mute(ID int(11) AUTO_INCREMENT , NAME varchar(64), DATE varchar(64), WARMEDBY varchar(64), PRIMARY KEY (`ID`));");
				con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS penalty(ID int(11) AUTO_INCREMENT , NAME varchar(64), WARM int(11), MUTE int(11), FREEZE int(11), REPORT int(11), REPORTBY int(11), PRIMARY KEY (`ID`));");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void update(String qry){
		if(isConnected()){
			try {
				con.createStatement().executeUpdate(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ResultSet getResult(String qry){
		if(isConnected()){
			try {
				return con.createStatement().executeQuery(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}

}
