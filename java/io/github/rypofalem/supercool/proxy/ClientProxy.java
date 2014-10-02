package io.github.rypofalem.supercool.proxy;

import net.minecraft.client.renderer.entity.RenderSnowball;
import io.github.rypofalem.supercool.EntitySuperEgg;
import io.github.rypofalem.supercool.SuperCool;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySuperEgg.class, new RenderSnowball( SuperCool.superEgg));
	}
	
}
