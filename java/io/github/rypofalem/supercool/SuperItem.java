package io.github.rypofalem.supercool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;



public class SuperItem extends Item {
	@SideOnly(Side.CLIENT) protected IIcon itemIcon;
	private EntitySuperEgg lastEgg =null;
	private  World clientWorld;

	public SuperItem() {
		this.setCreativeTab(SuperCool.tabSuperCool);
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack held, World world, EntityPlayer player) {
	    if(player.capabilities.isCreativeMode||player.inventory.consumeInventoryItem(SuperCool.superEgg))
	    {
	        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        if (!world.isRemote)
	        {
	        	lastEgg = new EntitySuperEgg(world, player);
	            world.spawnEntityInWorld(lastEgg);
	        }else{
	        	clientWorld = world;
	        }
	    }
	        return held;
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase living, ItemStack stack) {
		super.onEntitySwing(living, stack);
		if(lastEgg != null){
				lastEgg.explode();
		}
		return false;
	}
}
