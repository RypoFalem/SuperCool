package io.github.rypofalem.supercool.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEgg;
import net.minecraft.util.ResourceLocation;
import io.github.rypofalem.supercool.EntitySuperEgg;
import io.github.rypofalem.supercool.SuperCool;
import io.github.rypofalem.supercool.SuperItem;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySuperEgg.class, new RenderSnowball( SuperCool.superEgg));
	}
	
}
