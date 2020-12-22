package me.dkflab.durabilitydetect;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MiningListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inv = player.getInventory();
        ItemStack item = inv.getItemInMainHand();
        //config load
        FileConfiguration config = DurabilityDetect.getInstance().getConfig();
        int pickaxeDur = config.getInt("durability");
        int miningLevel = config.getInt("levelOfMiningFatigue");
        int miningDuration = config.getInt("lengthOfMiningFatigue") * 20;
        boolean gold = config.getBoolean("gold");
        boolean diamond = config.getBoolean("diamond");
        boolean iron = config.getBoolean("iron");
        boolean stone = config.getBoolean("stone");
        boolean wood = config.getBoolean("wood");
        switch(item.getType()) {
            // PICKAXE, AXE AND SHOVEL
            case IRON_PICKAXE:
            case IRON_SPADE:
            case IRON_AXE:
                if (250-item.getDurability() == pickaxeDur&&iron) {
                    alertPlayer(player);
                }
                break;
            case DIAMOND_SPADE:
            case DIAMOND_AXE:
            case DIAMOND_PICKAXE:
                if (1561-item.getDurability() == pickaxeDur&&diamond) {
                    alertPlayer(player);
                }
                break;
            case GOLD_PICKAXE:
            case GOLD_SPADE:
            case GOLD_AXE:
                if (32-item.getDurability() == pickaxeDur&&gold) {
                    alertPlayer(player);
                }
                break;
            case STONE_PICKAXE:
            case STONE_SPADE:
            case STONE_AXE:
                if (131-item.getDurability() == pickaxeDur&&stone) {
                    alertPlayer(player);
                }
                break;
            case WOOD_PICKAXE:
            case WOOD_AXE:
            case WOOD_SPADE:
                if (59-item.getDurability() == pickaxeDur&&wood) {
                    alertPlayer(player);
                }
                break;
            default:
                break;
            }
        }
        private void alertPlayer (Player player) {
            // varible declaration
            FileConfiguration config = DurabilityDetect.getInstance().getConfig();
            int miningLevel = config.getInt("levelOfMiningFatigue");
            int miningDuration = config.getInt("lengthOfMiningFatigue") * 20;
            // actual code
            player.sendMessage(ChatColor.GRAY + "Your " +ChatColor.RED + ChatColor.BOLD+"tool"+ChatColor.GRAY+" is low on durability.");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 3.0F, 0.5F);
            player.addPotionEffect((new PotionEffect(PotionEffectType.SLOW_DIGGING, miningDuration, miningLevel)));        }
    }
