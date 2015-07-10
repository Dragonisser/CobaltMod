package cobaltmod.main.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cobaltmod.entity.EntityLifeStealBall;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLifeStealStaff extends Item {
	
    private final ToolMaterial toolmaterial;
    protected boolean shoottwice = false;
    
	
	protected ItemLifeStealStaff(ToolMaterial tool)
	{
		this.toolmaterial = tool;
		this.setMaxDamage(200);
		this.isDamageable();
		
	}
	
	
	
    public float func_150931_i()
    {
        return this.toolmaterial.getDamageVsEntity();
    }
    
    
    
    
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if (par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage() && this.shoottwice == false)
		{
			par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
		}
	}
    
    
    
    
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	
		if (!par2World.isRemote)
		{
			if (par1ItemStack.getItemDamage() == 0 && this.shoottwice == false)
			{ 
				
				Vec3 look = par3EntityPlayer.getLookVec();
				EntityLifeStealBall lifeball = new EntityLifeStealBall(par2World, par3EntityPlayer, 1, 1, 1);
				lifeball.setPosition(par3EntityPlayer.posX + look.xCoord * 5, par3EntityPlayer.posY + look.yCoord * 5, par3EntityPlayer.posZ + look.zCoord * 5);
				lifeball.accelerationX = look.xCoord * 0.1;
				lifeball.accelerationY = look.yCoord * 0.1;
				lifeball.accelerationZ = look.zCoord * 0.1;

				par2World.spawnEntityInWorld(lifeball);	
				
				if (!par3EntityPlayer.capabilities.isCreativeMode)
				{
					this.shoottwice = true;
					par1ItemStack.damageItem(100, par3EntityPlayer);
				}
				else
				{
					this.shoottwice = false;
					par1ItemStack.damageItem(0, par3EntityPlayer);
				}	
			}
			else if (par1ItemStack.getItemDamage() == 100 && this.shoottwice == true) 
			{
				Vec3 look = par3EntityPlayer.getLookVec();
				EntityLifeStealBall lifeball = new EntityLifeStealBall(par2World, par3EntityPlayer, 1, 1, 1);
				lifeball.setPosition(par3EntityPlayer.posX + look.xCoord * 5, par3EntityPlayer.posY + look.yCoord * 5, par3EntityPlayer.posZ + look.zCoord * 5);
				lifeball.accelerationX = look.xCoord * 0.1;
				lifeball.accelerationY = look.yCoord * 0.1;
				lifeball.accelerationZ = look.zCoord * 0.1;
				par2World.spawnEntityInWorld(lifeball);
				par1ItemStack.damageItem(99, par3EntityPlayer);
				this.shoottwice = false;
			}
		}
		return par1ItemStack;
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
	
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List list, boolean i)
    {
    list.add("Staff made out of forgotten techniques");
    list.add("");
    list.add("Rightclick steals health from the Monster or Mob");
    }

}
