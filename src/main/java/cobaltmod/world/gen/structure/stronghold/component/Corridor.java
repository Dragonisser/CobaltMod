package cobaltmod.world.gen.structure.stronghold.component;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import cobaltmod.main.api.CMContent;

public class Corridor extends BaseComponent {

	public static final int X_LENGTH = 5;
	public static final int HEIGHT = 4;
	public static final int Z_LENGTH = 5;

	public Corridor(int direction, Random random, int x, int z) {
		super(direction);
		boundingBox = new StructureBoundingBox(x, 0, z, X_LENGTH, HEIGHT, Z_LENGTH);
	}

	/**
	 * Build component
	 */
	@Override
	public boolean addComponentParts(World world, Random random) {
		// TODO: is this right with the minX, minY, minZ etc.
		/**
		 * The Corridor:
		 * 
		 * ##### 
		 * #***# 
		 * #***#
		 * #####
		 * --> * air, # blocks  
		 */

		// args: worldObj, StructureBoundingBox, minX, minY, minZ, maxX, maxY,
		// maxZ
		this.fillWithAir(world, boundingBox, 1, 1, 0, 3, 2, 3);

		// block floor
		// args: worldObj, StructureBoundingBox, minX, minY, minZ, maxX, maxY,
		// maxZ, placeBlock, replaceBlock, always replace
		this.fillWithBlocks(world, boundingBox, 0, 0, 0, 4, 0, 0, CMContent.cobaltbrick, CMContent.cobaltbrick, false);
		
		// block roof
		// args: worldObj, StructureBoundingBox, minX, minY, minZ, maxX, maxY,
		// maxZ, placeBlock, replaceBlock, always replace
		this.fillWithBlocks(world, boundingBox, 0, 0, 4, 5, 0, 4, CMContent.cobaltbrick, CMContent.cobaltbrick, false);

		// block walls
		this.fillWithBlocks(world, boundingBox, 0, 1, 0, 0, 3, 0, CMContent.cobaltbrick, CMContent.cobaltbrick, false);
		this.fillWithBlocks(world, boundingBox, 4, 1, 0, 5, 3, 0, CMContent.cobaltbrick, CMContent.cobaltbrick, false);

		return true;
	}
}