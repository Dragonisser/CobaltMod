package cobaltmod.world.gen;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.DungeonHooks;
import cobaltmod.entity.tileentity.TileEntityCobexChest;
import cobaltmod.entity.tileentity.TileEntityLockedCobaltChest;
import cobaltmod.main.api.CMContent;
import cobaltmod.world.gen.chests.ChestGenHooksCobalt;

public class WorldGenCobaltDungeon extends WorldGeneratorDim {

	private boolean lockedChest = false;

	public static final WeightedRandomChestContent[] chestContent = new WeightedRandomChestContent[] {
			new WeightedRandomChestContent(CMContent.blueberry, 0, 3, 6, 25), new WeightedRandomChestContent(CMContent.cobaltingot, 0, 1, 4, 10),
			new WeightedRandomChestContent(CMContent.cobaltfertilizer, 0, 2, 4, 10), new WeightedRandomChestContent(CMContent.redcabbageseeds, 0, 3, 5, 10),
			new WeightedRandomChestContent(CMContent.cobaltplate, 0, 1, 1, 2), new WeightedRandomChestContent(CMContent.cobaltboots, 0, 1, 1, 2),
			new WeightedRandomChestContent(CMContent.cobalthelmet, 0, 1, 1, 2), new WeightedRandomChestContent(CMContent.cobaltlegs, 0, 1, 1, 2),
			new WeightedRandomChestContent(CMContent.chestkey, 0, 1, 1, 1) };

	public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {

		byte b0 = 3;
		int l = p_76484_2_.nextInt(2) + 2;
		int i1 = p_76484_2_.nextInt(2) + 2;
		int j1 = 0;
		int k1;
		int l1;
		int i2;

		for (k1 = p_76484_3_ - l - 1; k1 <= p_76484_3_ + l + 1; ++k1) {
			for (l1 = p_76484_4_ - 1; l1 <= p_76484_4_ + b0 + 1; ++l1) {
				for (i2 = p_76484_5_ - i1 - 1; i2 <= p_76484_5_ + i1 + 1; ++i2) {
					Material material = p_76484_1_.getBlock(k1, l1, i2).getMaterial();

					if (l1 == p_76484_4_ - 1 && !material.isSolid()) {
						return false;
					}

					if (l1 == p_76484_4_ + b0 + 1 && !material.isSolid()) {
						return false;
					}

					if ((k1 == p_76484_3_ - l - 1 || k1 == p_76484_3_ + l + 1 || i2 == p_76484_5_ - i1 - 1 || i2 == p_76484_5_ + i1 + 1) && l1 == p_76484_4_
							&& p_76484_1_.isAirBlock(k1, l1, i2) && p_76484_1_.isAirBlock(k1, l1 + 1, i2)) {
						++j1;
					}
				}
			}
		}

		if (j1 >= 1 && j1 <= 5) {
			for (k1 = p_76484_3_ - l - 1; k1 <= p_76484_3_ + l + 1; ++k1) {
				for (l1 = p_76484_4_ + b0; l1 >= p_76484_4_ - 1; --l1) {
					for (i2 = p_76484_5_ - i1 - 1; i2 <= p_76484_5_ + i1 + 1; ++i2) {
						if (k1 != p_76484_3_ - l - 1 && l1 != p_76484_4_ - 1 && i2 != p_76484_5_ - i1 - 1 && k1 != p_76484_3_ + l + 1
								&& l1 != p_76484_4_ + b0 + 1 && i2 != p_76484_5_ + i1 + 1) {
							p_76484_1_.setBlockToAir(k1, l1, i2);
						} else if (l1 >= 0 && !p_76484_1_.getBlock(k1, l1 - 1, i2).getMaterial().isSolid()) {
							p_76484_1_.setBlockToAir(k1, l1, i2);
						} else if (p_76484_1_.getBlock(k1, l1, i2).getMaterial().isSolid()) {
							if (l1 == p_76484_4_ - 1 && p_76484_2_.nextInt(4) != 0) {
								p_76484_1_.setBlock(k1, l1, i2, CMContent.cobaltbrick, 0, 2);
							} else {
								p_76484_1_.setBlock(k1, l1, i2, CMContent.cobaltbrick, 0, 2);
							}
						}
					}
				}
			}

			k1 = 0;

			while (k1 < 2) {
				l1 = 0;

				while (true) {
					if (l1 < 3) {
						label101: {
							i2 = p_76484_3_ + p_76484_2_.nextInt(l * 2 + 1) - l;
							int j2 = p_76484_5_ + p_76484_2_.nextInt(i1 * 2 + 1) - i1;

							if (p_76484_1_.isAirBlock(i2, p_76484_4_, j2)) {
								int k2 = 0;

								if (p_76484_1_.getBlock(i2 - 1, p_76484_4_, j2).getMaterial().isSolid()) {
									++k2;
								}

								if (p_76484_1_.getBlock(i2 + 1, p_76484_4_, j2).getMaterial().isSolid()) {
									++k2;
								}

								if (p_76484_1_.getBlock(i2, p_76484_4_, j2 - 1).getMaterial().isSolid()) {
									++k2;
								}

								if (p_76484_1_.getBlock(i2, p_76484_4_, j2 + 1).getMaterial().isSolid()) {
									++k2;
								}

								if (k2 == 1) {
									double d = Math.random();
									if (d < 0.1) {
										lockedChest = true;
										p_76484_1_.setBlock(i2, p_76484_4_, j2, CMContent.lockedcobaltchest, 0, 2);
										// Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new
										// ChatComponentText("Generated dungeon with lockedchest at x: "
										// + i2
										// + " y: " + p_76484_4_ + " z: " +
										// j2));
									} else {
										lockedChest = false;
										p_76484_1_.setBlock(i2, p_76484_4_, j2, CMContent.cobexchest, 0, 2);
										// Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new
										// ChatComponentText("Generated dungeon with chest at x: "
										// + i2
										// + " y: " + p_76484_4_ + " z: " +
										// j2));
									}

									// Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new
									// ChatComponentText("Generated dungeon with chest at x: "
									// + i2
									// + " y: " + p_76484_4_ + " z: " + j2));
									// System.out.println("Generated dungeon with chest at x: "
									// + i2 + " y: " + p_76484_4_ + " z: " +
									// j2);

									TileEntity tileentitychest;

									if (lockedChest) {
										tileentitychest = (TileEntityLockedCobaltChest) p_76484_1_.getTileEntity(i2, p_76484_4_, j2);
									} else {
										tileentitychest = (TileEntityCobexChest) p_76484_1_.getTileEntity(i2, p_76484_4_, j2);
									}

									if (tileentitychest != null) {
										WeightedRandomChestContent.generateChestContents(p_76484_2_,
												ChestGenHooksCobalt.getItems(ChestGenHooksCobalt.COBALT_DUNGEON_CHEST, p_76484_2_),
												(IInventory) tileentitychest,
												ChestGenHooksCobalt.getCount(ChestGenHooksCobalt.COBALT_DUNGEON_CHEST, p_76484_2_));
									}
									break label101;
								}
							}
							++l1;
							continue;
						}
					}
					++k1;
					break;
				}
			}

			p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) p_76484_1_.getTileEntity(p_76484_3_, p_76484_4_, p_76484_5_);

			if (tileentitymobspawner != null) {
				tileentitymobspawner.func_145881_a().setEntityName("CobaltGuardianMinion");
			} else {
				System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + ", " + p_76484_5_ + ")");
			}

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Randomly decides which spawner to use in a dungeon
	 */
	@SuppressWarnings("unused")
	private String pickMobSpawner(Random p_76543_1_) {
		return DungeonHooks.getRandomDungeonMob(p_76543_1_);
	}
}