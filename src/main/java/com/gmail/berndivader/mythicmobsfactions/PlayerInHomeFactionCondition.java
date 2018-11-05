package com.gmail.berndivader.mythicmobsfactions;

import org.bukkit.entity.Player;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.conditions.IEntityCondition;

public 
class 
PlayerInHomeFactionCondition
extends
AbstractCustomCondition
implements
IEntityCondition 
{
	public PlayerInHomeFactionCondition(String line, MythicLineConfig mlc) {
		super(line,mlc);
	}

	@Override
	public boolean check(AbstractEntity entity) {
		if(entity.isPlayer()) {
			return FactionsHelper.playerInHomeFaction((Player)entity.getBukkitEntity());
		}
		return false;
	}
}