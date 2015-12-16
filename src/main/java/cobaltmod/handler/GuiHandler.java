package cobaltmod.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cobaltmod.entity.tileentity.TileEntityAltar;
import cobaltmod.entity.tileentity.TileEntityCobaltFurnace;
import cobaltmod.entity.tileentity.TileEntityCorruptedStoneFurnace;
import cobaltmod.entity.tileentity.TileEntityRitualStone;
import cobaltmod.gui.client.GuiAltar;
import cobaltmod.gui.client.GuiBackpack;
import cobaltmod.gui.client.GuiBlueWoodWorkBench;
import cobaltmod.gui.client.GuiCobaltFurnace;
import cobaltmod.gui.client.GuiCorruptedStoneFurnace;
import cobaltmod.gui.client.GuiRecipeBook;
import cobaltmod.gui.client.GuiRitualStone;
import cobaltmod.gui.inventory.InventoryBackpack;
import cobaltmod.gui.server.ContainerAltar;
import cobaltmod.gui.server.ContainerBackpack;
import cobaltmod.gui.server.ContainerBlueWoodWorkBench;
import cobaltmod.gui.server.ContainerCobaltFurnace;
import cobaltmod.gui.server.ContainerCorruptedStoneFurnace;
import cobaltmod.gui.server.ContainerRitualStone;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static int AltarId = 0;
	public static int RecipeBookId = 1;
	public static int CobaltFurnaceId = 2;
	public static int RitualStoneId = 3;
	public static int BlueWoodWorkBenchId = 4;
	public static int BackpackId = 5;
	public static int CorruptedStoneFurnaceId = 6;
	public static int NeutralizerId = 7;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		switch (ID) {
		case 0:
			return ID == AltarId ? new ContainerAltar(player.inventory, (TileEntityAltar) tileEntity) : null;
		case 1:
			return null;
		case 2:
			return ID == CobaltFurnaceId ? new ContainerCobaltFurnace(player.inventory, (TileEntityCobaltFurnace) tileEntity) : null;
		case 3:
			return ID == RitualStoneId ? new ContainerRitualStone(player.inventory, (TileEntityRitualStone) tileEntity) : null;
		case 4:
			return ID == BlueWoodWorkBenchId && world.getBlock(x, y, z) == CMContent.cobexworkbench ? new ContainerBlueWoodWorkBench(player.inventory, world, x, y, z) : null;
		case 5:
			ItemStack[] armor = player.inventory.armorInventory;

			if (player != null) {
				if (player.getHeldItem() != null && player.getHeldItem().getItem() == CMContent.bluebackpack) {
					return ID == 5 ? new ContainerBackpack(player, player.inventory, new InventoryBackpack(player.getHeldItem())) : null;
				} else if (armor[2] != null) {
					Item item = armor[2].getItem();
					if (item instanceof ItemArmor) {

						ItemArmor itemA = (ItemArmor) item;
						if (itemA.getArmorMaterial() == CMMain.BackpackArmor || item == CMContent.cobaltplatebackpack) {

							return ID == BackpackId ? new ContainerBackpack(player, player.inventory, new InventoryBackpack(armor[2])) : null;
						}
					}
				}
			}
		case 6:
			return ID == CorruptedStoneFurnaceId ? new ContainerCorruptedStoneFurnace(player.inventory, (TileEntityCorruptedStoneFurnace) tileEntity) : null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		switch (ID) {
		case 0:
			return ID == AltarId ? new GuiAltar(player.inventory, (TileEntityAltar) tileEntity) : null;
		case 1:
			return ID == RecipeBookId ? new GuiRecipeBook(player) : null;
		case 2:
			return ID == CobaltFurnaceId ? new GuiCobaltFurnace(player.inventory, (TileEntityCobaltFurnace) tileEntity) : null;
		case 3:
			return ID == RitualStoneId ? new GuiRitualStone(player.inventory, (TileEntityRitualStone) tileEntity) : null;
		case 4:
			return ID == BlueWoodWorkBenchId && world.getBlock(x, y, z) == CMContent.cobexworkbench ? new GuiBlueWoodWorkBench(player.inventory, world, x, y, z) : null;
		case 5:
			ItemStack[] armor = player.inventory.armorInventory;

			if (player != null) {

				if (player.getHeldItem() != null && player.getHeldItem().getItem() == CMContent.bluebackpack) {

					return ID == 5 ? new GuiBackpack((ContainerBackpack) new ContainerBackpack(player, player.inventory, new InventoryBackpack(
							player.getHeldItem()))) : null;
				} else if (armor[2] != null) {

					Item item = armor[2].getItem();
					if (item instanceof ItemArmor) {

						ItemArmor itemA = (ItemArmor) item;
						if (itemA.getArmorMaterial() == CMMain.BackpackArmor || item == CMContent.cobaltplatebackpack) {

							return ID == BackpackId ? new GuiBackpack((ContainerBackpack) new ContainerBackpack(player, player.inventory,
									new InventoryBackpack(armor[2]))) : null;
						}
					}
				}
			}
		case 6:
			return ID == CorruptedStoneFurnaceId ? new GuiCorruptedStoneFurnace(player.inventory, (TileEntityCorruptedStoneFurnace) tileEntity) : null;
		}
		return null;
	}
//	
//	
//	private boolean checkForBackpack(EntityPlayer player) {
//		return false;
//		
//	}

}
