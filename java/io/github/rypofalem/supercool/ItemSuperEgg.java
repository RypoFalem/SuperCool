package io.github.rypofalem.supercool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.item.Item;

public class ItemSuperEgg extends Item {
	@SideOnly(Side.CLIENT) protected IIcon itemIcon;

	public ItemSuperEgg() {
		super();
		this.setCreativeTab(SuperCool.tabSuperCool);
		setMaxStackSize(64);
	}

}
