package com.gmail.berndivader.mythicmobsfactions;

import java.util.Optional;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.factions.entity.MPlayerColl;
import com.massivecraft.massivecore.ps.PS;

public class FactionsHelper {
	
	static Optional<BoardColl>boardColl=Optional.empty();
	static Optional<FactionColl>factionColl=Optional.empty();
	static Optional<MPlayerColl>mPlayerColl=Optional.empty();
	
	static {
		boardColl=Optional.ofNullable(BoardColl.get());
		factionColl=Optional.ofNullable(FactionColl.get());
		mPlayerColl=Optional.ofNullable(MPlayerColl.get());
	}

	private static enum FlagTypes {
		animals, 
		monsters, 
		peaceful, 
		endergrief, 
		explosions, 
		firespread,
		friendlyfire,
		infpower,
		offlineexplosions,
		open, 
		permanent,
		powergain, 
		powerloss, 
		pvp, 
		zombiegrief
	}

	public static boolean checkRegionFlag(Location l, String flag) {
		if(!boardColl.isPresent()) return false;
		Faction faction=boardColl.get().getFactionAt(PS.valueOf(l));
		if (faction==null) return false;
		FlagTypes flagtype=FlagTypes.monsters;
		try {
			FlagTypes.valueOf(flag);
		} catch (Exception ex) {
			return false;
		}
		return faction.getFlag(flagtype.name());
	}
	
	public static boolean inFaction(Location l,String[]regions) {
		if(FactionsHelper.boardColl.isPresent()) {
			Faction faction=FactionsHelper.boardColl.get().getFactionAt(PS.valueOf(l));
			if(faction==null) return false;
			String factionName=faction.getComparisonName().toLowerCase();
			int size=regions.length;
			for(int i1=0;i1<size;i1++) {
				if(regions[i1].equals(factionName)) return true;
			}
		}
		return false;
	}
	
	public static boolean playersFaction(Player player,String[]factions) {
		if(mPlayerColl.isPresent()) {
			MPlayer mplayer=mPlayerColl.get().getByName(player.getName());
			int size=factions.length;
			String faction=mplayer.getFactionName().toLowerCase();
			for(int i1=0;i1<size;i1++) {
				if(faction.equals(factions[i1])) return true;
			}
		}
		return false;
	}
	
	public static boolean playerInHomeFaction(Player player) {
		if(mPlayerColl.isPresent()&&boardColl.isPresent()) {
			MPlayer mplayer=mPlayerColl.get().getByName(player.getName());
			String playersFaction=mplayer.getFactionName().toLowerCase();
			String locationsFaction=boardColl.get().getFactionAt(PS.valueOf(player.getLocation())).getComparisonName();
			return playersFaction.equals(locationsFaction);
		}
		return false;
	}
	
	
}
