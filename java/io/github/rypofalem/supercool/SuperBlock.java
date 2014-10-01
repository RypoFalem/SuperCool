package io.github.rypofalem.supercool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class SuperBlock extends Block {

	@SideOnly(Side.CLIENT) protected IIcon blockIcon;
	@SideOnly(Side.CLIENT) protected IIcon blockIconTop;
	
	protected SuperBlock() {
		super(Material.ground);
		this.setCreativeTab(SuperCool.tabSuperCool);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister p_149651_1_){
		blockIcon = p_149651_1_.registerIcon(SuperCool.MODID + ":" + this.getUnlocalizedName().substring(5));
		blockIconTop = p_149651_1_.registerIcon(SuperCool.MODID + ":" + this.getUnlocalizedName().substring(5) + "Top");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata){
		if(side ==1){ return blockIconTop;}
		else return blockIcon;
	}

}
