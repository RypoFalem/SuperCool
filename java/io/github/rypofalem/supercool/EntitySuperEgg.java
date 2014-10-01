package io.github.rypofalem.supercool;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntitySuperEgg extends EntityThrowable {
	
	private float explosionSize = 1.5F; 
	private float explosionDamage = 25.0F;
	private float explosionDamageSize = 8.0F;
	private int ticks =0;

	  public EntitySuperEgg(World world)
	    {
	        super(world);
	    }
	  
	    public EntitySuperEgg(World world, EntityLivingBase thrower)
	    {
	        super(world, thrower);
	    }
	    
	    public EntitySuperEgg(World world, double par2, double par4, double par6)
	    {
	        super(world, par2, par4, par6);
	    }
	    
	    @Override
	    protected void onImpact(MovingObjectPosition pos){
	    	explode();
	        this.setDead();
	    }
	    
	    private void explode(){
	    	double x = this.posX;
	    	double y = this.posY;
	    	double z = this.posZ;
	        SuperEggExplosion explosion = new SuperEggExplosion(this.worldObj, this, x, y, z, explosionSize, explosionDamage, explosionDamageSize );
	        explosion.isFlaming = false;
	        explosion.isSmoking = true;
	        if(!this.worldObj.isRemote){
	        	explosion.doExplosionA();
	        }
	        explosion.doExplosionB(true);
	    }
	    
	    @Override
	    public void onUpdate(){
	    	if(++ticks > 100){
	    		explode();
	    		this.setDead();
	    	}
	    	super.onUpdate();
	    }
	    
	    @Override
	    protected float getGravityVelocity()
	    {
	        return 0.02F;
	    }
}
