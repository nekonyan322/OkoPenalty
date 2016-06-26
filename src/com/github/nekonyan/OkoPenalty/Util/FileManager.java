package com.github.nekonyan.OkoPenalty.Util;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.github.nekonyan.OkoPenalty.Daisuke;

public class FileManager {
	

	
	public static File GetConfigFile(){
		return new File("plugins/OkoPenalty", "mysql.yml");
		
	}
	
	public static FileConfiguration getConfigFileConfigration(){
		return YamlConfiguration.loadConfiguration(GetMySQLFile());
	}
	

	public static void setStanderdConfig(){
		FileConfiguration cfg = getMySQLFileConfigration();
		cfg.options().copyDefaults(true);
		cfg.addDefault("management1", "Remi_Oko");
		cfg.addDefault("management2", "Mon_chi");
		cfg.addDefault("management3", "tatsuki0214");
		cfg.addDefault("management4", "Angelo_Nine0219");
		cfg.addDefault("management5", "nekonyan0322");
		try {
			cfg.save(GetMySQLFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void readConfig() {
		FileConfiguration cfg = getMySQLFileConfigration();

		Daisuke.instance.management1 = cfg.getString("management1");
		Daisuke.instance.management2 = cfg.getString("management2");
		Daisuke.instance.management3 = cfg.getString("management3");
		Daisuke.instance.management4 = cfg.getString("management4");
		Daisuke.instance.management5 = cfg.getString("management5");
		
	}
	
		public static File GetMySQLFile(){
			return new File("plugins/OkoPenalty", "mysql.yml");
			
		}
		
		public static FileConfiguration getMySQLFileConfigration(){
			return YamlConfiguration.loadConfiguration(GetMySQLFile());
		}
		

		public static void setStanderdMySQL(){
			FileConfiguration cfg = getMySQLFileConfigration();
			cfg.options().copyDefaults(true);
			cfg.addDefault("username", "username");
			cfg.addDefault("password", "password");
			cfg.addDefault("database", "OkoPenalty");
			cfg.addDefault("host", "localhost");
			cfg.addDefault("port", "3306");
			try {
				cfg.save(GetMySQLFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		public static void readMySQL() {
			FileConfiguration cfg = getMySQLFileConfigration();

			MySQL.username = cfg.getString("username");
			MySQL.password = cfg.getString("password");
			MySQL.database = cfg.getString("database");
			MySQL.host = cfg.getString("host");
			MySQL.port = cfg.getString("port");
			
		}

}
