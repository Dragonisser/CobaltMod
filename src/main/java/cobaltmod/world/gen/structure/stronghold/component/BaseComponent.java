package cobaltmod.world.gen.structure.stronghold.component;

import net.minecraft.world.World;
import cobaltmod.world.gen.structure.CComponent;

public class BaseComponent extends CComponent {

	protected int leftXEnd = 0;
	protected int rightXEnd = 0;
	protected int topXEnd = 0;
	protected int leftZEnd = 0;
	protected int rightZEnd = 0;
	protected int topZEnd = 0;
	protected int yEnd = 0;
	protected BaseComponent prevComponent;
	protected BaseComponent[] nextComponents;

	protected BaseComponent(int direction) {
		super(direction);
	}

	/**
	 * Return ground level at x z coordinates
	 */
	protected int getGroundLevel(World world, int x, int z) {
		return world.getTopSolidOrLiquidBlock(x, z);
	}

	/**
	 * Return Left X end coord for next component
	 */
	public int getLeftXEnd() {
		return this.getXWithOffset(leftXEnd, leftZEnd);
	}

	/**
	 * Return Left Z end coord for next component
	 */
	public int getLeftZEnd() {
		return this.getZWithOffset(leftXEnd, leftZEnd);
	}

	/**
	 * Return right X end coord for next component
	 */
	public int getRightXEnd() {
		return this.getXWithOffset(rightXEnd, rightZEnd);
	}

	/**
	 * Return component direction
	 */
	public int getDirection() {
		return coordBaseMode;
	}
}