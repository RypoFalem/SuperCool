package io.github.rypofalem.supercool;

import io.github.rypofalem.supercool.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = SuperCool.MODID, version = SuperCool.VERSION)
public class SuperCool {
	public static final String MODID = "SuperCool";
	public static final String VERSION = "1.7.10-0.0.0";
	public static final String mymod = "io.github.rypofalem.supercool";
	@SidedProxy(clientSide=mymod + ".proxy.ClientProxy", serverSide=mymod + ".proxy.CommonProxy")
	public static CommonProxy proxy;
	public static Block superBlock;
	public static Item superItem;
	public static Item superEgg;
	public static CreativeTabs tabSuperCool = new CreativeTabsSuperCool("SuperCool");
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		superBlock = new SuperBlock().setBlockName("superBlock");
		GameRegistry.registerBlock(superBlock,  superBlock.getUnlocalizedName().substring(5));
		superItem = new SuperItem().setUnlocalizedName("superItem").setTextureName(MODID + ":" + "superitem");
		GameRegistry.registerItem(superItem, superItem.getUnlocalizedName().substring(5));
		superEgg = new ItemSuperEgg().setUnlocalizedName("superEgg").setTextureName(MODID + ":" + "superegg");
		GameRegistry.registerItem(superEgg, superEgg.getUnlocalizedName().substring(5));
		EntityRegistry.registerModEntity(EntitySuperEgg.class, "Super Egg", 0, this, 64, 10, true);
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		ItemStack feather = new ItemStack(Items.feather);
		ItemStack rawChicken = new ItemStack (Items.chicken);
		ItemStack dispenser = new ItemStack (Blocks.dispenser);
		ItemStack hopper = new ItemStack (Blocks.hopper);
		ItemStack tnt = new ItemStack(Blocks.tnt);
		ItemStack egg = new ItemStack(Items.egg);
		ItemStack button = new ItemStack(Blocks.stone_button);
		GameRegistry.addRecipe(new ItemStack(superItem), " d ", "bxh", "yyy",
		        'x', rawChicken, 'y', feather, 'h', hopper, 'd', dispenser, 'b', button);
		GameRegistry.addShapelessRecipe(new ItemStack(superEgg),tnt, egg );
		MinecraftForge.EVENT_BUS.register( new SuperEventHandler());
		FMLCommonHandler.instance().bus().register(new SuperEventHandler());
	}
	
	
}
