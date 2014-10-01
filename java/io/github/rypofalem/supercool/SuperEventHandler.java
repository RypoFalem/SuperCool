package io.github.rypofalem.supercool;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SuperEventHandler {

	public SuperEventHandler() {
		
	}
	
	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent e) {
		
		if ( e.action == Action.RIGHT_CLICK_AIR
				&& !(e.entityPlayer.inventory.getCurrentItem().getItem() == (null))
				&& e.entityPlayer.inventory.getCurrentItem().getItem() instanceof SuperItem) {
			SuperItem item = (SuperItem) e.entityPlayer.inventory.getCurrentItem().getItem();
			EntityPlayer p = e.entityPlayer;
			World w = p.getEntityWorld();
			//item.throwExplosiveEgg(w, p);
		}
	}
	
}
