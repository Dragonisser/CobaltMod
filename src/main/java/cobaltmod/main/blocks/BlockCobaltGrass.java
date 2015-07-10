package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cobaltmod.entity.EntityBlueBuddy;
import cobaltmod.entity.EntityBlueSlime;
import cobaltmod.entity.EntityCobaltAuraFX;
import cobaltmod.entity.EntityCobaltGuardian;
import cobaltmod.entity.EntityCobaltGuardianMinion;
import cobaltmod.entity.EntityCobaltZombie;
import cobaltmod.handler.AchievementHandler;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCobaltGrass extends Block implements IGrowable {

	public BlockCobaltGrass() {
		super(Material.grass);
		this.setHardness(0.6F);
		this.setStepSound(Block.soundTypeGrass);
		this.setLightOpacity(225);
		this.setTickRandomly(true);
	}

	public int var6 = 0;

	@SideOnly(Side.CLIENT)
	private IIcon grasstop;

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("mod_cobalt:cobaltgrass");
		this.grasstop = par1IconRegister.registerIcon("mod_cobalt:cobaltgrasstop");

	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.grasstop : (par1 == 0 ? CMContent.cobaltdirt.getBlockTextureFromSide(par1) : this.blockIcon);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		if (par5 == 1) {
			return this.grasstop;
		} else if (par5 == 0) {
			return CMContent.cobaltdirt.getBlockTextureFromSide(par5);
		} else {
			Material material = par1IBlockAccess.getBlock(par2, par3 + 1, par4).getMaterial();
			return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.blockIcon;
		}
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (!par1World.isRemote) {
			if ((par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
					|| par1World.getBlock(par2, par3 + 1, par4).getMaterial() == Material.water
					|| par1World.getBlock(par2, par3 + 1, par4).getMaterial() == Material.lava) {
				par1World.setBlock(par2, par3, par4, CMContent.cobaltdirt);
			} else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 5) {
				for (int l = 0; l < 5; ++l) {
					int i1 = par2 + par5Random.nextInt(3) - 1;
					int j1 = par3 + par5Random.nextInt(5) - 3;
					int k1 = par4 + par5Random.nextInt(3) - 1;

					Block spreadable = par1World.getBlock(i1, j1, k1);
					Block below = par1World.getBlock(i1, par3 - 1, i1);

					// if (CMApiReplace.map.containsKey(spreadable) &&
					// par1World.getBlockLightValue(i1, par3 + 1, k1) >= 4
					// && par1World.getBlockLightOpacity(i1, par3 + 1, k1) <= 2)
					// {
					//
					// par1World.setBlock(i1, j1, k1,
					// CMApiReplace.map.get(spreadable));
					//
					// } else if (below == CMContent.cobaltgrass) {
					// par1World.setBlock(par2, par3, par4,
					// CMContent.cobaltdirt);
					// }
				}
			}
		}
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(CMContent.cobaltdirt);
	}

	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
		if (par5Entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) par5Entity;

			player.addStat(AchievementHandler.cobaltachiev, 1);

			ItemStack[] armor = player.inventory.armorInventory;

			if (armor[0] != null) {
				Item item = armor[0].getItem();
				if (item instanceof ItemArmor) {
					ItemArmor itemA = (ItemArmor) item;
					if (itemA.getArmorMaterial() == ItemArmor.ArmorMaterial.CLOTH) {
						par5Entity.attackEntityFrom(DamageSource.magic, 2F);
						return;
					}
					if (itemA.getArmorMaterial() == CMContent.CobaltOreArmor || itemA.getArmorMaterial() == ItemArmor.ArmorMaterial.IRON
							|| itemA.getArmorMaterial() == ItemArmor.ArmorMaterial.DIAMOND) {
						return;
					}
				}
			}
		}
		if (par5Entity instanceof EntityLivingBase) {
			EntityLivingBase elb = (EntityLivingBase) par5Entity;

			if (elb.isPotionActive(CMContent.potion_cobalt_resistance)) {
				return;
			}
		}
		if (par5Entity instanceof EntityCobaltZombie) {
			return;
		}
		if (par5Entity instanceof EntityCobaltGuardian) {
			return;
		}
		if (par5Entity instanceof EntityBlueBuddy) {
			return;
		}
		if (par5Entity instanceof EntityCobaltGuardianMinion) {
			return;
		}
		if (par5Entity instanceof EntityBlueSlime) {
			return;
		}
		par5Entity.attackEntityFrom(DamageSource.magic, 4F);

	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

		if (par5Random.nextInt(10) == 0) {

			double d0 = (double) ((float) par2 + par5Random.nextFloat());
			double d1 = (double) ((float) par3 + +1.1F);
			double d2 = (double) ((float) par4 + par5Random.nextFloat());
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;

			FMLClientHandler.instance().getClient().effectRenderer.addEffect(new EntityCobaltAuraFX(FMLClientHandler.instance().getClient().theWorld, d0, d1,
					d2, d3, d4, d5));
		}
	}

	public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		int l = 0;

		while (l < 128) {
			int i1 = p_149853_3_;
			int j1 = p_149853_4_ + 1;
			int k1 = p_149853_5_;
			int l1 = 0;

			while (true) {
				if (l1 < l / 16) {
					i1 += p_149853_2_.nextInt(3) - 1;
					j1 += (p_149853_2_.nextInt(3) - 1) * p_149853_2_.nextInt(3) / 2;
					k1 += p_149853_2_.nextInt(3) - 1;

					if (p_149853_1_.getBlock(i1, j1 - 1, k1) == CMContent.cobaltgrass && !p_149853_1_.getBlock(i1, j1, k1).isNormalCube()) {
						++l1;
						continue;
					}
				} else if (p_149853_1_.getBlock(i1, j1, k1).getMaterial() == Material.air) {
					if (p_149853_2_.nextInt(8) != 0) {
						if (CMContent.bluetallgrass.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, CMContent.bluetallgrass, 1, 3);
						}
					} else {
						// p_149853_1_.getBiomeGenForCoords(i1,
						// k1).plantFlower(p_149853_1_, p_149853_2_, i1, j1,
						// k1);
						// new
						// WorldGenFlowers(CMContent.bellflower).generate(p_149853_1_,
						// p_149853_2_, i1, j1, k1); //Bellflower
					}
				}

				++l;
				break;
			}
		}
	}

	@Override
	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		// TODO Auto-generated method stub
		return true;
	}
}