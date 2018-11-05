# MythicMobsFactionsAddon <br>

### [download](https://github.com/BerndiVader/MythicMobsFactionsAddon/blob/master/build/libs/MythicMobsFactions-0.001-SNAPSHOT.jar)

Collection of various mythicmobs conditions to use with Factions. <br>
Depends on: **Factions** - **MassiveCore** - **MythicMobs** <br>

## Conditions:<br><br>

### infactionsregion <br>
Use this condition to determine if the entity is inside a specific factions region. <br><br>
*Usage* <br>
`infactionsregion{factions=thisfaction,anotherfaction,wilderness;action=[TRUE][FALSE][CAST][CASTINSTEAD][POWER]}` <br><br>

### factionsflags <br>
Use this condition to determine the factions flags.<br><br>
[valid flags](https://github.com/MassiveCraft/Factions/blob/master/src/com/massivecraft/factions/entity/MFlag.java)
 <br><br>
*Usage* <br>
`factionsflags{flags=animals,monsters,open;action=[TRUE][FALSE][CAST][CASTINSTEAD][POWER]}` <br><br>

### playerinfactions <br>
Determine if the player is in any of the given factions. Leave factions empty to determine if the player is in no faction. <br><br>
*Usage* <br>
`playerinfactions{factions=blubb;action=[TRUE][FALSE][CAST][CASTINSTEAD][POWER]}` <br><br>

### playerinhomefaction <br>
Determine if the player is inside the home faction region.<br><br>
*Usage* <br>
`playerinhomefaction{action=[TRUE][FALSE][CAST][CASTINSTEAD][POWER]}` <br><br>



