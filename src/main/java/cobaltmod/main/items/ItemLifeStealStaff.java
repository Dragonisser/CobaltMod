package cobaltmod.main.items;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLifeStealStaff extends Item {

	private final ToolMaterial toolmaterial;
	protected boolean shoottwice = false;

	protected ItemLifeStealStaff(ToolMaterial tool) {
		this.toolmaterial = tool;
		this.setMaxDamage(200);
		this.isDamageable();
		this.setMaxStackSize(1);

	}

	public float func_150931_i() {
		return this.toolmaterial.getDamageVsEntity();
	}

	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if (par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage() && this.shoottwice == false) {
			par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
		}
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

		if (par1ItemStack.stackTagCompound != null) {
			if (par2World.isRemote) {
				System.out.println("CLIENT: " + par1ItemStack.stackTagCompound.getInteger("entityID"));
			} else {
				System.out.println("SERVER: " + par1ItemStack.stackTagCompound.getInteger("entityID"));
			}
		}

		if (!par2World.isRemote) {
			if (par1ItemStack.getItemDamage() == 0) {
				if (!par3EntityPlayer.capabilities.isCreativeMode) {
					par1ItemStack.damageItem(1, par3EntityPlayer);

					EntityLiving entity;

					MovingObjectPosition objectMouseOver = Minecraft.getMinecraft().objectMouseOver;

					if (objectMouseOver != null && objectMouseOver.typeOfHit == MovingObjectType.ENTITY) {
						if (par1ItemStack.stackTagCompound == null) {
							par1ItemStack.stackTagCompound = new NBTTagCompound();

							par1ItemStack.stackTagCompound.setInteger("entityID", objectMouseOver.entityHit.getEntityId());
						} else {
							par1ItemStack.stackTagCompound.setInteger("entityID", objectMouseOver.entityHit.getEntityId());
						}
						
						entity = (EntityLiving) objectMouseOver.entityHit;
						if (par3EntityPlayer.getDistanceToEntity(entity) < 10) {

							System.out.println("pootis");
							System.out.println(entity.getHealth());
							//entity.setEntityId(par1ItemStack.stackTagCompound.getInteger("entityID"));
							entity.attackEntityFrom(DamageSource.magic, 0.5F);
							par3EntityPlayer.setHealth(par3EntityPlayer.getHealth() + 0.5F);

						}

					}

				}
			}
		}
		return par1ItemStack;
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.epic;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List list, boolean i) {
		list.add("Staff made out of forgotten techniques");
		list.add("");
		list.add("Rightclick steals health from the Monster or Mob");
	}

}
