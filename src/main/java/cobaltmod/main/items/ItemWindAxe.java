package cobaltmod.main.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cobaltmod.entity.EntityCobaltGuardian;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWindAxe extends ItemAxe {
	
	
	private boolean isinair = false;
	
	protected ItemWindAxe(ToolMaterial tool) {
		super(tool);
		this.setMaxDamage(200);
		this.isDamageable();
		
		
		
	}
	
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
	    return EnumRarity.epic;
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return true;
	}
	
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if (par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage())
		{
			par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
			//System.out.println(par1ItemStack.getItemDamage());
		}

		if (par5 && (par3Entity instanceof EntityPlayer))
		{
			EntityPlayer entityplayer = (EntityPlayer)par3Entity;
			if (!par2World.isRemote && !entityplayer.capabilities.isCreativeMode)
			{
				if (entityplayer.getCurrentEquippedItem().getItem() == CMContent.windaxe)
				{
					if (par1ItemStack.getItemDamage() > 0)
					{
						entityplayer.fallDistance = 0.0F;
					}
				}
			}
		}
		
		if (par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage())
		{
			if (par3Entity instanceof EntityPlayer)
			{
				EntityPlayer entityplayer = (EntityPlayer)par3Entity;
		        if (this.isinair)
		        {
		        	for (int cp = 0; cp <= 10; cp++)
			        {
						double d0 = itemRand.nextGaussian() * 0.02D;
				        double d1 = itemRand.nextGaussian() * 0.02D;
				        double d2 = itemRand.nextGaussian() * 0.02D;
				        
				        double dx = entityplayer.posX;
				        double dy = entityplayer.posY - 1.8;
				        double dz = entityplayer.posZ;
				        
			        	par2World.spawnParticle("cloud", dx, dy, dz, d0, d1, d2);
			        }
		        }
		        
			}
		}
		
		if (par3Entity instanceof EntityPlayer)
		{
			EntityPlayer entityplayer = (EntityPlayer)par3Entity;
			
			int x = (int) entityplayer.posX;
	        int y = (int) (entityplayer.posY - entityplayer.getYOffset());
	        int z = (int) entityplayer.posZ;
	        
	        if (par1ItemStack.getItemDamage() <= 190)
	        {
	        	if (entityplayer.worldObj.getBlock(x, y - 1, z) != Blocks.air)
	        	{
	        		this.isinair = false;
	        	}	
	        }
		}
	}
	
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		if (par2EntityLivingBase instanceof EntityCobaltGuardian)
		{
			return false;
		}
		else
		{
			float forwardspeed = 0.5F;
			float upwardspeed = 0.5F;
		
			double x = -1 * Math.sin(par3EntityLivingBase.rotationYaw * Math.PI / 180) * forwardspeed;
			double z = Math.cos(par3EntityLivingBase.rotationYaw * Math.PI / 180) * forwardspeed;
			double y = upwardspeed;

			par2EntityLivingBase.addVelocity(x, y, z);
		}
		return false;	
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if (par1ItemStack.getItemDamage() == 0)
		{
			double x = -1 * Math.sin(par3EntityPlayer.rotationYaw * Math.PI / 180) * (float) CMMain.forwardspeed;
			double z = Math.cos(par3EntityPlayer.rotationYaw * Math.PI / 180) * (float) CMMain.forwardspeed;
			double y = (float) CMMain.upwardspeed;

	        par3EntityPlayer.addVelocity(x, y, z);

	        par1ItemStack.damageItem(199, par3EntityPlayer);
            
            this.isinair = true;
        	
		}
		return par1ItemStack;
    }
	
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List list, boolean i)
    {
	list.add(StatCollector.translateToLocal("tooltip.windaxe.first_line"));
    list.add("");
    list.add(StatCollector.translateToLocal("tooltip.windaxe.second_line"));
    list.add("");
    list.add(StatCollector.translateToLocal("tooltip.windaxe.third_line"));
    }
}
