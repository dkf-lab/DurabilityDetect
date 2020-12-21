package me.dkflab.durabilitydetect;

import com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
                    player.sendMessage(ChatColor.GRAY + "Your " +ChatColor.WHITE + ChatColor.BOLD+"tool"+ChatColor.GRAY+" is low on durability!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 3.0F, 0.5F);
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SLOW_DIGGING, miningDuration, miningLevel)));
                }
                break;
            case DIAMOND_SPADE:
            case DIAMOND_AXE:
            case DIAMOND_PICKAXE:
                if (1561-item.getDurability() == pickaxeDur&&diamond) {
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SLOW_DIGGING, miningDuration, miningLevel)));
                    player.sendMessage(ChatColor.GRAY + "Your " +ChatColor.BLUE + ChatColor.BOLD+"tool"+ChatColor.GRAY+" is low on durability.");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 3.0F, 0.5F);
                }
                break;
            case GOLD_PICKAXE:
            case GOLD_SPADE:
            case GOLD_AXE:
                if (32-item.getDurability() == pickaxeDur&&gold) {
                    player.sendMessage(ChatColor.GRAY + "Your " +ChatColor.GOLD + ChatColor.BOLD+"tool"+ChatColor.GRAY+" is low on durability.");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 3.0F, 0.5F);
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SLOW_DIGGING, miningDuration, miningLevel)));
                }
                break;
            case STONE_PICKAXE:
            case STONE_SPADE:
            case STONE_AXE:
                if (131-item.getDurability() == pickaxeDur&&stone) {
                    player.sendMessage(ChatColor.GRAY + "Your " +ChatColor.DARK_GRAY + ChatColor.BOLD+"tool"+ChatColor.GRAY+" is low on durability.");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 3.0F, 0.5F);
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SLOW_DIGGING, miningDuration, miningLevel)));
                }
                break;
            case WOOD_PICKAXE:
            case WOOD_AXE:
            case WOOD_SPADE:
                if (59-item.getDurability() == pickaxeDur&&wood) {
                    player.sendMessage(ChatColor.GRAY + "Your " +ChatColor.GREEN + ChatColor.BOLD+"tool"+ChatColor.GRAY+" is low on durability.");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 3.0F, 0.5F);
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SLOW_DIGGING, miningDuration, miningLevel)));
                }
                break;
            default:
                break;
            }
        }
    }
