package io.github.rypofalem.supercool;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntitySuperEgg extends EntityThrowable {
	
	public float explosionSize = 1.5F; 
	public float explosionDamage = 25.0F;
	public float explosionDamageSize = 8.0F;
	private int ticks =0;
	public boolean isClientDead=false;

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
	    }
	    
	    public void explode(){
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
	        this.setDead();
	    }
	    
	    public void vanillaExplode(){
	    	double x = this.posX;
	    	double y = this.posY;
	    	double z = this.posZ;
	        Explosion explosion = new Explosion(this.worldObj, this, x, y, z, explosionSize);
	        explosion.isFlaming = false;
	        explosion.isSmoking = true;
	        if(!this.worldObj.isRemote){
	        	explosion.doExplosionA();
	        }
	        explosion.doExplosionB(true);
	        this.setDead();
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
