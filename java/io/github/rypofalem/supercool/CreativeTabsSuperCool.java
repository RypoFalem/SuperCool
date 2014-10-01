package io.github.rypofalem.supercool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTabsSuperCool extends CreativeTabs {

	public CreativeTabsSuperCool(String lable) {
		super(lable);
	}

	public CreativeTabsSuperCool(int p_i1853_1_, String p_i1853_2_) {
		super(p_i1853_1_, p_i1853_2_);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.dirt);
	}

}
