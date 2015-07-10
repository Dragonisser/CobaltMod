package cobaltmod.main.blocks;

import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidDarkWater extends Fluid {

	public BlockFluidDarkWater(String fluidName) {
		super(fluidName);
		// TODO Auto-generated constructor stub
	}
	
	 public IIcon getStillIcon()
	    {
	        return this.block.getIcon(0, 0);
	    }

	    public IIcon getFlowingIcon()
	    {
	        return this.block.getIcon(1, 0);
	    }
}
