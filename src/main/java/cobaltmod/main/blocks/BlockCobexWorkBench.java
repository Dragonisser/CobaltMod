package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cobaltmod.handler.GuiHandler;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCobexWorkBench extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_150035_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_150034_b;

    public BlockCobexWorkBench()
    {
        super(Material.wood);
        this.setHardness(2.5F);
        this.setStepSound(Block.soundTypeWood);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_150035_a : (p_149691_1_ == 0 ? CMContent.cobexwood.getBlockTextureFromSide(p_149691_1_) : (p_149691_1_ != 2 && p_149691_1_ != 4 ? this.blockIcon : this.field_150034_b));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("mod_cobalt:bluewoodworkbench_side");
        this.field_150035_a = p_149651_1_.registerIcon("mod_cobalt:bluewoodworkbench_top");
        this.field_150034_b = p_149651_1_.registerIcon("mod_cobalt:bluewoodworkbench_front");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

    	if (!par5EntityPlayer.isSneaking()) 
		{
			par5EntityPlayer.openGui(CMMain.instance, GuiHandler.BlueWoodWorkBenchId, par1World, par2, par3, par4);
			return true;
		} 
		else 
		{
			return false;
		}
	}
}