package cobaltmod.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cobaltmod.entity.TileEntityAltar;
import cobaltmod.entity.TileEntityCobaltFurnace;
import cobaltmod.entity.TileEntityCorruptedStoneFurnace;
import cobaltmod.entity.TileEntityRitualStone;
import cobaltmod.gui.ContainerAltar;
import cobaltmod.gui.ContainerBackpack;
import cobaltmod.gui.ContainerBlueWoodWorkBench;
import cobaltmod.gui.ContainerCobaltFurnace;
import cobaltmod.gui.ContainerCorruptedStoneFurnace;
import cobaltmod.gui.ContainerRitualStone;
import cobaltmod.gui.GuiAltar;
import cobaltmod.gui.GuiBackpack;
import cobaltmod.gui.GuiBlueWoodWorkBench;
import cobaltmod.gui.GuiCobaltFurnace;
import cobaltmod.gui.GuiCorruptedStoneFurnace;
import cobaltmod.gui.GuiRecipeBook;
import cobaltmod.gui.GuiRitualStone;
import cobaltmod.gui.InventoryBackpack;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		switch (ID) {
		case 0:
			return ID == 0 ? new ContainerAltar(player.inventory, (TileEntityAltar) tileEntity) : null;
		case 2:
			return ID == 2 ? new ContainerCobaltFurnace(player.inventory, (TileEntityCobaltFurnace) tileEntity) : null;
		case 3:
			return ID == 3 ? new ContainerRitualStone(player.inventory, (TileEntityRitualStone) tileEntity) : null;
		case 4:
			return ID == 4 && world.getBlock(x, y, z) == CMContent.cobexworkbench ? new ContainerBlueWoodWorkBench(player.inventory, world, x, y, z) : null;
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

							return ID == 5 ? new ContainerBackpack(player, player.inventory, new InventoryBackpack(armor[2])) : null;
						}
					}
				}
			}
		case 6:
			return ID == 6 ? new ContainerCorruptedStoneFurnace(player.inventory, (TileEntityCorruptedStoneFurnace) tileEntity) : null;
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		switch (ID) {
		case 0:
			return ID == 0 ? new GuiAltar(player.inventory, (TileEntityAltar) tileEntity) : null;
		case 1:
			return ID == 1 ? new GuiRecipeBook(player) : null;
		case 2:
			return ID == 2 ? new GuiCobaltFurnace(player.inventory, (TileEntityCobaltFurnace) tileEntity) : null;
		case 3:
			return ID == 3 ? new GuiRitualStone(player.inventory, (TileEntityRitualStone) tileEntity) : null;
		case 4:
			return ID == 4 && world.getBlock(x, y, z) == CMContent.cobexworkbench ? new GuiBlueWoodWorkBench(player.inventory, world, x, y, z) : null;
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

							return ID == 5 ? new GuiBackpack((ContainerBackpack) new ContainerBackpack(player, player.inventory,
									new InventoryBackpack(armor[2]))) : null;
						}
					}
				}
			}
		case 6:
			return ID == 6 ? new GuiCorruptedStoneFurnace(player.inventory, (TileEntityCorruptedStoneFurnace) tileEntity) : null;
		}
		return null;
	}

}
