package me.dkflab.durabilitydetect;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.PlayerInventory;

public class DamageListener implements Listener {

    @EventHandler
    public void entityDamage(EntityDamageEvent event) {
        if (event.getEntityType().equals(EntityType.PLAYER)) {
            FileConfiguration config = DurabilityDetect.getInstance().getConfig();
            Player player = (Player) event.getEntity();
            PlayerInventory inv = player.getInventory();
            int helmet = config.getInt("helmet");
            int chestplate = config.getInt("chestplate");
            int leggings = config.getInt("leggings");
            int boots = config.getInt("boots");
            //helmet
            if (inv.getHelmet() != null && inv.getHelmet().getType() != null) {
                switch (inv.getHelmet().getType()) {
                    case DIAMOND_HELMET:
                        if (363 - inv.getHelmet().getDurability() == helmet) {
                            alertPlayer(player, "helmet");
                        }
                        if (363-inv.getHelmet().getDurability() == 0) {
                            brokenPlayer(player, "helmet");
                        }
                        break;
                    case LEATHER_HELMET:
                        if (55 - inv.getHelmet().getDurability() == helmet) {
                            alertPlayer(player, "helmet");
                        }
                        if (55-inv.getHelmet().getDurability() == 0) {
                            brokenPlayer(player, "helmet");
                        }
                        break;
                    case GOLD_HELMET:
                        if (77 - inv.getHelmet().getDurability() == helmet) {
                            alertPlayer(player, "helmet");
                        }
                        if (77-inv.getHelmet().getDurability() == 0) {
                            brokenPlayer(player, "helmet");
                        }
                        break;
                    case IRON_HELMET:
                    case CHAINMAIL_HELMET:
                        if (165 - inv.getHelmet().getDurability() == helmet) {
                            alertPlayer(player, "helmet");
                        }
                        if (165-inv.getHelmet().getDurability() == 0) {
                            brokenPlayer(player, "helmet");
                        }
                        break;
                }
            }
            //chestplate
            if(inv.getChestplate() != null && inv.getChestplate().getType() != null) {
                switch (inv.getChestplate().getType()) {
                    case DIAMOND_CHESTPLATE:
                        if (528 - inv.getChestplate().getDurability() == chestplate) {
                            alertPlayer(player, "chestplate");
                        }
                        if (528-inv.getChestplate().getDurability() == 0) {
                            brokenPlayer(player, "chestplate");
                        }
                        break;
                    case LEATHER_CHESTPLATE:
                        if (80 - inv.getChestplate().getDurability() == chestplate) {
                            alertPlayer(player, "chestplate");
                        }
                        if (80-inv.getChestplate().getDurability() == 0) {
                            brokenPlayer(player, "chestplate");
                        }
                        break;
                    case GOLD_CHESTPLATE:
                        if (112 - inv.getChestplate().getDurability() == chestplate) {
                            alertPlayer(player, "chestplate");
                        }
                        if (112-inv.getChestplate().getDurability() == 0) {
                            brokenPlayer(player, "chestplate");
                        }
                        break;
                    case IRON_CHESTPLATE:
                    case CHAINMAIL_CHESTPLATE:
                        if (240 - inv.getChestplate().getDurability() == chestplate) {
                            alertPlayer(player, "chestplate");
                        }
                        if (240-inv.getChestplate().getDurability() == 0) {
                            brokenPlayer(player, "chestplate");
                        }
                        break;
                }
            }
            //leggings
            if (inv.getLeggings() != null &&inv.getLeggings().getType() != null) {
                switch (inv.getLeggings().getType()) {
                    case DIAMOND_LEGGINGS:
                        if (495 - inv.getLeggings().getDurability() == leggings) {
                            alertPlayer(player, "leggings");
                        }
                        if (495-inv.getLeggings().getDurability() == 0) {
                            brokenPlayer(player, "leggings");
                        }
                        break;
                    case LEATHER_LEGGINGS:
                        if (75 - inv.getLeggings().getDurability() == leggings) {
                            alertPlayer(player, "leggings");
                        }
                        if (75-inv.getLeggings().getDurability() == 0) {
                            brokenPlayer(player, "leggings");
                        }
                        break;
                    case GOLD_LEGGINGS:
                        if (105 - inv.getLeggings().getDurability() == leggings) {
                            alertPlayer(player, "leggings");
                        }
                        if (105-inv.getLeggings().getDurability() == 0) {
                            brokenPlayer(player, "leggings");
                        }
                        break;
                    case IRON_LEGGINGS:
                    case CHAINMAIL_LEGGINGS:
                        if (225 - inv.getLeggings().getDurability() == leggings) {
                            alertPlayer(player, "leggings");
                        }
                        if (225-inv.getLeggings().getDurability() == 0) {
                            brokenPlayer(player, "leggings");
                        }
                        break;
                }
            }
            //boots
            if (inv.getBoots()!=null&&inv.getBoots().getType() != null) {
                switch (inv.getBoots().getType()) {
                    case DIAMOND_BOOTS:
                        if (429 - inv.getBoots().getDurability() == boots) {
                            alertPlayer(player, "boots");
                        }
                        if (429-inv.getBoots().getDurability() == 0) {
                            brokenPlayer(player, "boots");
                        }
                        break;
                    case LEATHER_BOOTS:
                        if (65 - inv.getBoots().getDurability() == boots) {
                            alertPlayer(player, "boots");
                        }
                        if (65-inv.getBoots().getDurability() == 0) {
                            brokenPlayer(player, "boots");
                        }
                        break;
                    case GOLD_BOOTS:
                        if (91 - inv.getBoots().getDurability() == boots) {
                            alertPlayer(player, "boots");
                        }
                        if (91-inv.getBoots().getDurability() == 0) {
                            brokenPlayer(player, "boots");
                        }
                        break;
                    case IRON_BOOTS:
                    case CHAINMAIL_BOOTS:
                        if (195 - inv.getBoots().getDurability() == boots) {
                            alertPlayer(player, "boots");
                        }
                        if (195-inv.getBoots().getDurability() == 0) {
                            brokenPlayer(player, "boots");
                        }
                        break;
                }
            }
        }
    }
    private void alertPlayer(Player player, String type) {
        //do stuff
        player.playSound(player.getLocation(), Sound.ENTITY_ENDEREYE_DEATH, 3.0F, 0.5F);
        if (type.equals("chestplate") || type.equals("helmet")) {
            player.sendMessage(ChatColor.GRAY + "Your " + ChatColor.RED + ChatColor.BOLD + type + ChatColor.GRAY + " is " +ChatColor.RED + "low" +ChatColor.GRAY + " durability!");
        }
        else {
            player.sendMessage(ChatColor.GRAY + "Your " + ChatColor.RED + ChatColor.BOLD + type + ChatColor.GRAY + " are " + ChatColor.RED + "low" + ChatColor.GRAY + " durability!");
        }
    }
    private void brokenPlayer (Player player, String type) {
        player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 5.0f, 0.5f);
        if (type.equals("chestplate")||type.equals("helmet")) {
            player.sendMessage(ChatColor.GRAY + "Your " + ChatColor.DARK_RED + ChatColor.BOLD + type + ChatColor.GRAY + " is " + ChatColor.DARK_RED + ChatColor.BOLD + "broken!");
        }
        else {
            player.sendMessage(ChatColor.GRAY + "Your " + ChatColor.DARK_RED + ChatColor.BOLD + type + ChatColor.GRAY + " are "+ ChatColor.DARK_RED + ChatColor.BOLD + "broken!");
        }
    }

}

