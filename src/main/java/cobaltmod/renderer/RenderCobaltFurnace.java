package cobaltmod.renderer;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class RenderCobaltFurnace extends RenderBlocks implements ISimpleBlockRenderingHandler {

public RenderCobaltFurnace(IBlockAccess par1iBlockAccess) {
super(par1iBlockAccess);
// TODO Auto-generated constructor stub
}

public static int cobaltfurnaceRenderId = RenderingRegistry.getNextAvailableRenderId();

public RenderCobaltFurnace() {
// probably need to copy/paste some code here
}

@Override
public void renderBlockAsItem(Block par1Block, int par2, float par3)
{
// just pre-set the side as '3'
super.renderBlockAsItem(par1Block, par2, 3);
}

@Override
public void renderInventoryBlock(Block block, int metadata, int modelId,
		RenderBlocks renderer) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
		Block block, int modelId, RenderBlocks renderer) {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean shouldRender3DInInventory(int modelId) {
	// TODO Auto-generated method stub
	return true;
}

@Override
public int getRenderId() {
	// TODO Auto-generated method stub
	return RenderCobaltFurnace.cobaltfurnaceRenderId;
}
}