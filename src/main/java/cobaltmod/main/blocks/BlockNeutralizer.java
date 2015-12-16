package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cobaltmod.entity.tileentity.TileEntityNeutralizer;
import cobaltmod.handler.GuiHandler;
import cobaltmod.main.CMMain;

public class BlockNeutralizer extends BlockContainer {

	protected BlockNeutralizer() {
		super(Material.rock);
		this.setHardness(2F);
		this.setResistance(3F);
		this.setStepSound(Block.soundTypeStone);		
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityNeutralizer();
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

    	if (!par5EntityPlayer.isSneaking()) 
		{
			par5EntityPlayer.openGui(CMMain.instance, GuiHandler.NeutralizerId, par1World, par2, par3, par4);
			return true;
		} 
		else 
		{
			return false;
		}
	}
}
