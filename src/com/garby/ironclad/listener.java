package com.garby.ironclad;
// /*

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class listener implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		 Player ePlayer = event.getPlayer();
         Bukkit.broadcastMessage("test msg");
         main.log.info(ePlayer.getName() +"has joined");
         Vetcheck.Vetchecker(ePlayer,ePlayer, false);
	}

}// */
