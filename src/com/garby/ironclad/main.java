package com.garby.ironclad;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

@SuppressWarnings({"SpellCheckingInspection","unused"})
public class main extends JavaPlugin {
		public static String hoursRequired;
		private Economy econ;
	    public static Permission perms;
	    private Chat chat;
		private static FileConfiguration config;
		private static File file;
		public static String rankname;
		public static String rankMsg;
		public static String rankPub;
		public static String rankEcho;
		public static boolean checkJoin;




	public static Logger log = Logger.getLogger("Minecraft");
	@Override
	public void onEnable() {
		// Plugin startup logic
	    log.info("[Garby's Plugin] Start up.");
		getCommand("vet").setExecutor(new Vetcheck());
	    this.onstart();
	    getServer().getPluginManager().registerEvents(new listener(), this);

		//config stuff
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		getConfig();
		getConfig().getInt("hours-required");
		hoursRequired = getConfig().getString( "hours-required" );
		rankname = getConfig().getString( "rank-name" );
		rankMsg = getConfig().getString("rank-message");
		rankPub = getConfig().getString("rank-public-message");
		rankEcho = getConfig( ).getString( "info-request-msg" );







	}

	@Override
	public void onDisable() {

	  }









	  private void onstart(){
	  	if (!setupEconomy()) {
            this.getLogger().severe("Disabled due to no Vault dependency found!");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        this.setupPermissions();
        this.setupChat();

	  }
		public static String chatformat(String format){
		return ChatColor.translateAlternateColorCodes('&', format);
		}
	  
	  
	  
	  private boolean setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider <Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return true;
      }

    private void setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
	    if ( rsp != null ) {
		    chat = rsp.getProvider();
	    }
    }

    private void setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
	    if ( rsp != null ) {
		    perms = rsp.getProvider();
	    }
    }

    public Economy getEconomy() {
        return econ;
    }

    public Permission getPermissions() {
        return perms;
    }

    public Chat getChat() {
        return chat;
    }}