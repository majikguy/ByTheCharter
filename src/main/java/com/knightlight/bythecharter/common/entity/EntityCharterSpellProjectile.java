package com.knightlight.bythecharter.common.entity;

import com.knightlight.bythecharter.common.CharterMod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCharterSpellProjectile extends EntityThrowable {

	public EntityCharterSpellProjectile(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		this.setSize(0.0F, 0.0F);
	}

	@Override
	protected void onImpact(MovingObjectPosition position) {

		EntityLightningBolt lightning = new EntityLightningBolt(this.worldObj, position.hitVec.xCoord, position.hitVec.yCoord, position.hitVec.zCoord);
		this.worldObj.addWeatherEffect(lightning);
		this.setDead();
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		for(int i = 0; i < 20; i++)
			CharterMod.proxy.generateCharterParticle(this);
	}
	
	@Override
	protected float getGravityVelocity() {
		return 0F;
	}
}
