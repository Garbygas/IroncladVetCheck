package com.garby.ironclad;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("SpellCheckingInspection")
public class Vetcheck implements CommandExecutor {

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
    	if (sender instanceof Player) {
            Player player = (Player) sender;

            //Vetchecker(player);
            Player qPlayer = player;
            //if (args.length == 1) qPlayer = Bukkit.getPlayer( args[ 0 ] );
            Vetchecker( qPlayer,player,true);
        }return false;}



    public static void Vetchecker(final Player player, final Player questener, Boolean Output) {
        // get how many days the player has played
        int hoursPlayed = ((player.getStatistic(Statistic.PLAY_ONE_MINUTE)/20)/60)/60;
        String playerName = player.getName();
        //int numHours = Integer.parseInt( hoursPlayed );
        int requiredTime = Integer.parseInt( main.hoursRequired );
        int morehours = requiredTime - hoursPlayed ;
        if(hoursPlayed >= requiredTime) {
            if (main.perms.playerInGroup(player, main.rankname))
            {
                main.perms.playerAddGroup(null, player, main.rankname);
                player.sendMessage(main.chatformat(main.rankMsg));
                //music
                for(Player p : Bukkit.getOnlinePlayers()) {
                    p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1, 0);
                }
                //when player has the time for vet rank
            }

            //insert if player has vet rank alrety


        }else{
            //when player does not have vet rank and they do not have the required time
            main.log.info("[RankCheck] "+player +"is not eligible for "+main.rankname+" (command send)");
            if( Output ){
                String msg = main.chatformat(main.rankEcho);
                msg = msg.replaceAll("<hrequired>",String.valueOf(morehours));
                msg = msg.replaceAll("<hplayed>", String.valueOf( hoursPlayed ) );
                msg = msg.replaceAll("<player>",player.getName());


                player.sendMessage(msg);
            }
            //send time played msg here
            //send time played msg here
            //send time played msg here

            }


        /*    String prefix = (ChatColor.LIGHT_PURPLE +  "🔥" + ChatColor.GOLD + "" + ChatColor.BOLD + "Ironclad" + ChatColor.RESET + ChatColor.DARK_RED +  "🔥"+ChatColor.RESET+ChatColor.BOLD+""+ChatColor.GOLD+">");
        if ( numHours <= requiredTime ) {
            main.perms.playerAddGroup( null , player , "mod" );
            player.sendMessage( playerName );
        }*/

    }
}
