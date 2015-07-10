package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockCobexStair extends BlockStairs {

	public BlockCobexStair(Block par2Block, int par3) {
		super(par2Block, par3);
		this.setHardness(3F);
		this.setResistance(4F);
		this.setStepSound(Block.soundTypeWood);
		this.setLightOpacity(1); 
	}

	public int getRenderType() {
		return 10;
	}
}