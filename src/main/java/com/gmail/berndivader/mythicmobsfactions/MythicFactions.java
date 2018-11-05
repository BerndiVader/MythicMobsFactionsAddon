package com.gmail.berndivader.mythicmobsfactions;

import java.util.Optional;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.massivecraft.factions.Factions;
import com.massivecraft.massivecore.MassiveCore;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicConditionLoadEvent;

public 
class
MythicFactions 
extends
JavaPlugin
implements
Listener
{
	private static MythicFactions plugin;
	static org.bukkit.plugin.PluginManager pluginmanager;
	static Optional<MythicMobs> mythicmobs;
	static Optional<Factions> factions;
	static Optional<MassiveCore> massivecore;
	static Logger logger;
	
	static {
		pluginmanager=Bukkit.getPluginManager();
		mythicmobs=Optional.ofNullable((MythicMobs)pluginmanager.getPlugin("MythicMobs"));
		factions=Optional.ofNullable((Factions)pluginmanager.getPlugin("Factions"));
		massivecore=Optional.ofNullable((MassiveCore)pluginmanager.getPlugin("MassiveCore"));
		logger=Bukkit.getLogger();
	}
	
	public static MythicFactions inst() {
		return plugin;
	}
	
	@Override
	public void onEnable() {
		plugin=this;
		if(mythicmobs.isPresent()&&factions.isPresent()&&massivecore.isPresent()) {
			pluginmanager.registerEvents(this,plugin);
			logger.info("Conditions registered.");
		}
	}
	
	@Override
	public void onDisable() {
		pluginmanager.disablePlugin(this);
	}
	
	@EventHandler
	public void registerConditions(MythicConditionLoadEvent e) {
		switch(e.getConditionName().toLowerCase()) {
		case "infactionsregion":
			e.register(new FactionsRegionCondition(e.getConfig().getLine(),e.getConfig()));
			break;
		case "factionsflags":
			e.register(new FactionsFlagCondition(e.getConfig().getLine(),e.getConfig()));
			break;
		case "playerinfactions":
			e.register(new PlayerInFactionsCondition(e.getConfig().getLine(), e.getConfig()));
			break;
		case "playerinhomefaction":
			e.register(new PlayerInHomeFactionCondition(e.getConfig().getLine(), e.getConfig()));
			break;
		}
	}

}
