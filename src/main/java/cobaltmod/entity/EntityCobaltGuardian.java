package cobaltmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cobaltmod.main.api.CMContent;

public class EntityCobaltGuardian extends EntityMob implements IBossDisplayData {
	public int deathTicks = 0;
	private int timerminion = 200;
	private int timerfireball = 400;
	private Entity targetedEntity;
	private int explosionStrength = 1;
	public int innerRotation = 0;
	private boolean dying = false;

	public EntityCobaltGuardian(World par1World) {
		super(par1World);
		this.setSize(this.width * 2F, this.height * 2.5F);
		this.isImmuneToFire = true;
		this.experienceValue = 50;
		this.innerRotation = this.rand.nextInt(100000);
		this.setHealth(this.getMaxHealth());

	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0D);

	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(17, new Integer(0));
	}

	@Override
	public void moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
	}

	protected int decreaseAirSupply(int par1) {
		return par1;
	}

	public boolean canBeCollidedWith() {
		return true;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	protected boolean isAIEnabled() {
		return true;
	}

	public int getTotalArmorValue() {
		return 20;
	}

	public void onLivingUpdate() {
		this.innerRotation++;
		this.timerminion--;

		if (this.targetedEntity == null) {
			this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 40.0D);

		}

		if (!dying) {
			if (!this.worldObj.isRemote && this.targetedEntity != null) {
				if (this.getHealth() >= 300) {
					if (this.timerminion <= 0) {
						this.timerminion = 200;
						this.spawnMinionStage(0);
						this.spawnShockWave(0.2D);
					}
				}
				if (this.getHealth() <= 300 && this.getHealth() >= 150) {
					if (this.timerminion <= 0) {
						this.timerminion = 300;
						this.spawnMinionStage(1);
						this.spawnAttractionWave(1.0D);
					}
				}
				if (this.getHealth() <= 200 && this.getHealth() >= 150) {
					this.timerfireball--;

					if (this.timerfireball <= 0) {
						this.spawnFireballStage(1);
						this.spawnShockWave(0.5D);
						this.spawnAttractionWave(0.5D);
						this.applyConfusion(1);
						this.timerfireball = 200;
					}
				}
				if (this.getHealth() <= 150) {
					this.timerfireball--;
					this.timerfireball--;

					if (this.timerfireball <= 0) {
						this.spawnFireballStage(0);
						this.spawnShockWave(1.0D);
						this.spawnAttractionWave(0.5D);
						this.applyConfusion(1.5);
						this.timerfireball = 75;

					}
				}
			}
		}

	}

	public int getWatchedTargetId(int par1) {
		return this.dataWatcher.getWatchableObjectInt(17 + par1);
	}

	protected String getLivingSound() {
		return "mob.zombie.say";
	}

	protected String getHurtSound() {
		return "mob.zombie.hurt";
	}

	protected String getDeathSound() {
		return "mob.wither.death";
	}

	protected void dropFewItems(boolean par1, int par2) {
		double d = Math.random();
		double d1 = Math.random();

		if (d < 0.5) {
			this.dropItem(CMContent.blueessence, 1 + this.rand.nextInt(3));
		}

		else if (d < 0.7) {
			if (d1 < 0.5) {
				this.dropItem(CMContent.windaxe, 1);
			} else {
				this.dropItem(CMContent.speedcobaltboots, 1);
			}

		}

		else {
		}
		this.dropItem(CMContent.cobaltnugget, 5 + rand.nextInt(3));

	}

	protected void onDeathUpdate() {

		++this.deathTicks;

		if (this.deathTicks >= 180 && this.deathTicks <= 200) {
			this.dying = true;
			float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.worldObj.spawnParticle("hugeexplosion", this.posX + (double) f, this.posY + 2.0D + (double) f1, this.posZ + (double) f2, 0.0D, 0.0D, 0.0D);
		}

		int i;
		int j;

		if (!this.worldObj.isRemote) {
			if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
				i = 1000;

				while (i > 0) {
					j = EntityXPOrb.getXPSplit(i);
					i -= j;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
				}
			}

			if (this.deathTicks == 1) {
				this.worldObj.playBroadcastSound(1018, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
			}
		}

		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;

		if (this.deathTicks == 200 && !this.worldObj.isRemote) {
			i = 2000;

			while (i > 0) {
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
			}
			this.setDead();
		}
	}

	protected void despawnEntity() {
	}

	protected void updateAITasks() {
	}

	// Selfmade Ai
	private void spawnMinionStage(int stage) {
		this.moveEntity(0D, 3.0D, 0D);

		EntityCobaltGuardianMinion entityCGM = new EntityCobaltGuardianMinion(this.worldObj);
		EntityCobaltGuardianMinion entityCGM1 = new EntityCobaltGuardianMinion(this.worldObj);

		switch (stage) {
		case 0:

			entityCGM.setLocationAndAngles(this.posX + Math.random(), this.posY + 1.5D, this.posZ + Math.random(), this.rotationYaw, this.rotationPitch);
			this.worldObj.spawnEntityInWorld(entityCGM);
			break;

		case 1:
			entityCGM.setLocationAndAngles(this.posX + Math.random(), this.posY + 1.5D, this.posZ + Math.random(), this.rotationYaw, this.rotationPitch);
			this.worldObj.spawnEntityInWorld(entityCGM);

			entityCGM1.setLocationAndAngles(this.posX + Math.random(), this.posY + 1.5D, this.posZ + Math.random(), this.rotationYaw, this.rotationPitch);
			this.worldObj.spawnEntityInWorld(entityCGM1);
			break;

		default:
			break;
		}
	}

	public void spawnFireballStage(int stage) {
		double d4 = 40.0D;

		if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity(this) < d4 * d4) {
			double d5 = this.targetedEntity.posX - this.posX;
			double d6 = this.targetedEntity.boundingBox.minY + (double) (this.targetedEntity.height / 2.0F) - (this.posY + (double) (this.height / 2.0F));
			double d7 = this.targetedEntity.posZ - this.posZ;
			this.renderYawOffset = this.rotationYaw = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;

			if (this.canEntityBeSeen(this.targetedEntity)) {

				EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.worldObj, this, d5, d6, d7);
				EntityLargeFireball entitylargefireball1 = new EntityLargeFireball(this.worldObj, this, d5, d6, d7);

				double d8 = 4.0D;
				Vec3 vec3 = this.getLook(1.0F);

				double d8_1 = 4.0D;
				Vec3 vec3_1 = this.getLook(1.0F);

				switch (stage) {
				case (0):
					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1008, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
					entitylargefireball.field_92057_e = this.explosionStrength;
					entitylargefireball.posX = this.posX + vec3.xCoord * d8;
					entitylargefireball.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
					entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
					this.worldObj.spawnEntityInWorld(entitylargefireball);
					break;

				case (1):

					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1008, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
					entitylargefireball.field_92057_e = this.explosionStrength;
					entitylargefireball.posX = this.posX + 1.0D + vec3.xCoord * d8;
					entitylargefireball.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
					entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
					this.worldObj.spawnEntityInWorld(entitylargefireball);

					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1008, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
					entitylargefireball1.field_92057_e = this.explosionStrength;
					entitylargefireball1.posX = this.posX - 1.0D + vec3_1.xCoord * d8_1;
					entitylargefireball1.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
					entitylargefireball1.posZ = this.posZ + vec3_1.zCoord * d8_1;
					this.worldObj.spawnEntityInWorld(entitylargefireball1);

				default:
					break;
				}
			}
		}
	}

	public void spawnShockWave(double y) {

		if (this.worldObj.getClosestVulnerablePlayerToEntity(this, 10.0D) != null) {
			EntityLivingBase entityplayer = (EntityLivingBase) this.worldObj.getClosestVulnerablePlayerToEntity(this, 10.0D);

			Vec3 vec = Vec3.createVectorHelper(entityplayer.posX - this.posX, entityplayer.posY - this.posY, entityplayer.posZ - this.posZ);
			double distance = vec.lengthVector();
			distance = 1 / distance;
			vec.normalize();
			vec.xCoord *= distance;
			vec.yCoord *= distance;
			vec.zCoord *= distance;

			double d = Math.random();
			if (d < 0.33) {
				entityplayer.addVelocity(vec.xCoord, y, vec.zCoord);
				entityplayer.velocityChanged = true;
			}
		}
	}

	public void spawnAttractionWave(double y) {

		if (this.worldObj.getClosestVulnerablePlayerToEntity(this, 30.0D) != null) {
			EntityLivingBase entityplayer = (EntityLivingBase) this.worldObj.getClosestVulnerablePlayerToEntity(this, 30.0D);

			Vec3 vec = Vec3.createVectorHelper(entityplayer.posX - this.posX, entityplayer.posY - this.posY, entityplayer.posZ - this.posZ);
			double distance = vec.lengthVector();
			distance = 1 / distance;
			vec.normalize();
			vec.xCoord *= distance;
			vec.yCoord *= distance;
			vec.zCoord *= distance;

			double d = Math.random();

			System.out.println(distance);
			if (distance > 0.036 && distance < 0.076) {
				System.out.println("Trying to attract");
				if (d < 0.5) {
					entityplayer.addVelocity(-vec.xCoord, y, -vec.zCoord);
					entityplayer.velocityChanged = true;
				}
			}

		}
	}

	public void applyConfusion(double durationMultiplier) {
		if (this.worldObj.getClosestVulnerablePlayerToEntity(this, 10.0D) != null) {
			EntityLivingBase entityplayer = (EntityLivingBase) this.worldObj.getClosestVulnerablePlayerToEntity(this, 10.0D);
			if (!entityplayer.isPotionActive(CMContent.potion_cobalt_confusion)) {
				entityplayer.addPotionEffect(new PotionEffect(CMContent.potion_cobalt_confusion.id, (int) (durationMultiplier * 15 * 20), 1));
			}
		}
	}
}