package me.badbones69.crazyenchantments.multisupport;

import me.badbones69.crazyenchantments.Main;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import me.ryanhamshire.GriefPrevention.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Support {
	
	public static boolean hasDakata(){
		if(Bukkit.getServer().getPluginManager().getPlugin("DakataAntiCheat")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasNoCheatPlus(){
		if(Bukkit.getServer().getPluginManager().getPlugin("NoCheatPlus")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasVault(){
		if(Bukkit.getServer().getPluginManager().getPlugin("Vault")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasWorldEdit(){
		if(Bukkit.getServer().getPluginManager().getPlugin("WorldEdit")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasWorldGuard(){
		if(Bukkit.getServer().getPluginManager().getPlugin("WorldGuard")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasFactions(){
		if(Bukkit.getServer().getPluginManager().getPlugin("Factions")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasFeudal(){
		if(Bukkit.getServer().getPluginManager().getPlugin("Feudal")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasAcidIsland(){
		if(Bukkit.getServer().getPluginManager().getPlugin("AcidIsland")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasASkyBlock(){
		if(Bukkit.getServer().getPluginManager().getPlugin("ASkyBlock")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasKingdoms(){
		if(Bukkit.getServer().getPluginManager().getPlugin("Kingdoms")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasSilkSpawner(){
		if(Bukkit.getServer().getPluginManager().getPlugin("SilkSpawners")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasSpartan(){
		if(Bukkit.getServer().getPluginManager().getPlugin("Spartan")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasMobStacker() {
		if(Bukkit.getServer().getPluginManager().getPlugin("MobStacker")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasMobStacker2() {
		if(Bukkit.getServer().getPluginManager().getPlugin("MobStacker2")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasStackMob() {
		if(Bukkit.getServer().getPluginManager().getPlugin("StackMob")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean hasMegaSkills() {
		if(Bukkit.getServer().getPluginManager().getPlugin("MegaSkills")!=null){
			return true;
		}
		return false;
	}
	
	public static boolean inTerritory(Player player){
		PlayerData playerData = GriefPrevention.instance.dataStore.getPlayerData(player.getUniqueId());
		Claim claim = GriefPrevention.instance.dataStore.getClaimAt(player.getLocation(), false, null);
		if (claim != null) {
			if (claim.allowBuild(player, Material.BRICK) == null) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isFriendly(Entity P, Entity O){
		if(P instanceof Player&&O instanceof Player) {
			Player player = (Player) P;
			Player other = (Player) O;
		}
		return false;
	}
	
	public static boolean canBreakBlock(Player player, Block block){
		PlayerData playerData = GriefPrevention.instance.dataStore.getPlayerData(player.getUniqueId());
		Claim claim = GriefPrevention.instance.dataStore.getClaimAt(player.getLocation(), false, null);
		if (claim != null) {
			if (claim.allowBuild(player, Material.BRICK) == null) {
				return true;
			}
			return false;
		}
		return true;
	}
	
	public static boolean allowsPVP(Location loc){
		Claim claim = GriefPrevention.instance.dataStore.getClaimAt(loc, false, null);
		if (claim == null)
		{
			return  true;
		}
		return false;
	}
	
	public static boolean allowsBreak(Location loc){
		return true;
	}
	
	public static boolean allowsExplotions(Location loc){
		Claim claim = GriefPrevention.instance.dataStore.getClaimAt(loc, false, null);
		if (claim == null) {
			return true;
		}
		return false;
	}
	
	public static boolean inWingsRegion(Location loc){
		if(Main.settings.getConfig().contains("Settings.EnchantmentOptions.Wings.Regions")){
			Claim claim = GriefPrevention.instance.dataStore.getClaimAt(loc, false, null);
			if (claim != null) {
				if (!claim.isAdminClaim()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void noStack(Entity en) {
		if (hasMobStacker()) {
			MobStacker.noStack(en);
			return;
		}
		if (hasMobStacker2()) {
			MobStacker2.noStack(en);
			return;
		}
	}
	
}