package io.github.rypofalem.supercool;


import java.util.Iterator;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySuperEgg extends EntityThrowable {
	
	public float explosionSize = 1.5F; 
	public float explosionDamage = 25.0F;
	public float explosionDamageSize = 8.0F;
	private int ticks =0;
	public boolean isClientDead =false;
	private EntityLivingBase shooter;

	  public EntitySuperEgg(World world)
	    {
	        super(world);
	    }
	  
	    public EntitySuperEgg(World world, EntityLivingBase thrower)
	    {
	        super(world, thrower);
	        this.shooter = thrower;
	    }
	    
	    public EntitySuperEgg(World world, double par2, double par4, double par6)
	    {
	        super(world, par2, par4, par6);
	    }
	    
	    @Override
	    protected void onImpact(MovingObjectPosition pos){
	    	explode();
	    }
	    
	    public void explode(){
	    	if(!this.worldObj.isRemote && !isDead){
	    		//worldObj.createExplosion(this, posX, posY, posZ, explosionSize, true);
	    		SuperEggExplosion explosion = new SuperEggExplosion(this.worldObj, this, posX, posY, posZ, explosionSize, explosionDamage, explosionDamageSize);
	    		explosion.isFlaming = false;
	    		explosion.isSmoking = true;
	    		explosion.doExplosionA();
	    		explosion.doExplosionB(false);
//	    		if (!explosion.isFlaming)
//	            {
//	                explosion.affectedBlockPositions.clear();
//	            }
	            Iterator iterator = this.worldObj.playerEntities.iterator();

	            while (iterator.hasNext())
	            {
	                EntityPlayer entityplayer = (EntityPlayer)iterator.next();

	                if (entityplayer.getDistanceSq(posX, posY, posZ) < 4096.0D)
	                {
	                    ((EntityPlayerMP)entityplayer).playerNetServerHandler.sendPacket(new S27PacketExplosion(posX, posY, posZ, explosionSize, explosion.affectedBlockPositions, (Vec3)explosion.func_77277_b().get(entityplayer)));
	                }
	            }
	    		this.setDead();
	    	}
	    }
	    
	    @Override
	    public void onUpdate(){
	    	super.onUpdate();
	    	if(++ticks > 100){
	    		explode();
	    	}
	    }
	    
	    @Override
	    protected float getGravityVelocity()
	    {
	        return 0.02F;
	    }
}
