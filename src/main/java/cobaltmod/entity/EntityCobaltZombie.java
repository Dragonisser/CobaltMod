package cobaltmod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import cobaltmod.handler.AchievementHandler;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;

public class EntityCobaltZombie extends EntityMob {

	private boolean canDie = true;

	public EntityCobaltZombie(World par1World) {
		super(par1World);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, true));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityAnimal.class, 1.0D, true));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));

		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAnimal.class, 0, true));

		// ChunkCoordinates chunkcoordinates = par1World.getSpawnPoint();
		// this.setLocationAndAngles((double)chunkcoordinates.posX + 0.5D,
		// (double)(chunkcoordinates.posY + 1), (double)chunkcoordinates.posZ +
		// 0.5D, 0.0F, 0.0F);
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(35.0D);
	}

	public void onKillEntity(EntityLivingBase par1EntityLivingBase) {
		super.onKillEntity(par1EntityLivingBase);

		if ((this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD)
				&& par1EntityLivingBase instanceof EntityPlayer) {
			if (this.rand.nextBoolean()) {
				return;
			}

			EntityCobaltZombie entityzombie = new EntityCobaltZombie(this.worldObj);
			entityzombie.copyLocationAndAnglesFrom(par1EntityLivingBase);
			this.worldObj.removeEntity(par1EntityLivingBase);
			entityzombie.onSpawnWithEgg((IEntityLivingData) null);

			this.worldObj.spawnEntityInWorld(entityzombie);
			this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1016, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
		}
	}

	protected void entityInit() {
		super.entityInit();
	}
	
	public void setCanDie(boolean canDie) {
		this.canDie = canDie;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	protected boolean isAIEnabled() {
		return true;
	}

	public int getTotalArmorValue() {
		return 3;
	}

	public void onLivingUpdate() {
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote && this.canDie) {
			if (this.worldObj.provider.dimensionId == CMMain.cobaltdimension) {
				float var1 = this.getBrightness(1.0F);

				if (var1 > 0.5F
						&& this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY),
								MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
					this.setDead();
					;
				}
			}
		}
		super.onLivingUpdate();
	}

	protected String getLivingSound() {
		return "mob.zombie.say";
	}

	protected String getHurtSound() {
		return "mob.zombie.hurt";
	}

	protected String getDeathSound() {
		return "mob.zombie.death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.worldObj.playSoundAtEntity(this, "mob.zombie.step", 0.15F, 1.0F);
	}

	protected Item getDropItem() {
		return CMContent.cobaltnugget;
	}

	protected void dropFewItems(boolean par1, int par2) {
		Item item = this.getDropItem();

		if (item != null) {
			int j = this.rand.nextInt(3);

			if (par2 > 0) {
				j += this.rand.nextInt(par2 + 1);
			}

			for (int k = 0; k < j; ++k) {
				this.dropItem(item, 1);
			}
		}
	}

	public void onDeath(DamageSource par1DamageSource) {
		if (par1DamageSource.getSourceOfDamage() instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) par1DamageSource.getEntity();
			entityplayer.triggerAchievement(AchievementHandler.cobaltachiev13);

		}
		super.onDeath(par1DamageSource);
	}

	public World func_82194_d() {
		return this.worldObj;
	}

	protected boolean canDespawn() {
		return true;
	}
}