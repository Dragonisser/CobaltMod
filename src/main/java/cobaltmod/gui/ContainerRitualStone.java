package cobaltmod.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import cobaltmod.entity.tileentity.TileEntityCobaltFurnace;
import cobaltmod.entity.tileentity.TileEntityRitualStone;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerRitualStone extends Container
{
private TileEntityRitualStone highSpeed;
private int lastCookTime = 0;
private int lastBurnTime = 0;
private int lastItemBurnTime = 0;
public ContainerRitualStone(InventoryPlayer par1InventoryPlayer, TileEntityRitualStone par2TileEntityHighSpeedFurnace)
{
         this.highSpeed = par2TileEntityHighSpeedFurnace;
         //this.addSlotToContainer(new Slot(par2TileEntityHighSpeedFurnace, 0, 56, 17));
         this.addSlotToContainer(new Slot(par2TileEntityHighSpeedFurnace, 0, 56, 35));
         this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player, par2TileEntityHighSpeedFurnace, 1, 116, 35));
         int var3;
         for (var3 = 0; var3 < 3; ++var3)
         {
                 for (int var4 = 0; var4 < 9; ++var4)
                 {
                         this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
                 }
         }
         for (var3 = 0; var3 < 9; ++var3)
         {
                 this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
         }
}
public void addCraftingToCrafters(ICrafting par1ICrafting)
{
         super.addCraftingToCrafters(par1ICrafting);
         par1ICrafting.sendProgressBarUpdate(this, 0, this.highSpeed.furnaceCookTime);
         par1ICrafting.sendProgressBarUpdate(this, 1, this.highSpeed.furnaceBurnTime);
         par1ICrafting.sendProgressBarUpdate(this, 2, this.highSpeed.currentItemBurnTime);
}
/**
         * Looks for changes made in the container, sends them to every listener.
         */
public void detectAndSendChanges()
{
         super.detectAndSendChanges();
         for (int var1 = 0; var1 < this.crafters.size(); ++var1)
         {
                 ICrafting var2 = (ICrafting)this.crafters.get(var1);
                 if (this.lastCookTime != this.highSpeed.furnaceCookTime)
                 {
                         var2.sendProgressBarUpdate(this, 0, this.highSpeed.furnaceCookTime);
                 }
                 if (this.lastBurnTime != this.highSpeed.furnaceBurnTime)
                 {
                         var2.sendProgressBarUpdate(this, 1, this.highSpeed.furnaceBurnTime);
                 }
                 if (this.lastItemBurnTime != this.highSpeed.currentItemBurnTime)
                 {
                         var2.sendProgressBarUpdate(this, 2, this.highSpeed.currentItemBurnTime);
                 }
         }
         this.lastCookTime = this.highSpeed.furnaceCookTime;
         this.lastBurnTime = this.highSpeed.furnaceBurnTime;
         this.lastItemBurnTime = this.highSpeed.currentItemBurnTime;
}
@SideOnly(Side.CLIENT)
public void updateProgressBar(int par1, int par2)
{
         if (par1 == 0)
         {
                 this.highSpeed.furnaceCookTime = par2;
         }
         if (par1 == 1)
         {
                 this.highSpeed.furnaceBurnTime = par2;
         }
         if (par1 == 2)
         {
                 this.highSpeed.currentItemBurnTime = par2;
         }
}
public boolean canInteractWith(EntityPlayer par1EntityPlayer)
{
         return this.highSpeed.isUseableByPlayer(par1EntityPlayer);
}
/**
         * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
         */

public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
{
    ItemStack itemstack = null;
    Slot slot = (Slot)this.inventorySlots.get(par2);

    if (slot != null && slot.getHasStack())
    {
        ItemStack itemstack1 = slot.getStack();
        itemstack = itemstack1.copy();

        if (par2 == 2)
        {
            if (!this.mergeItemStack(itemstack1, 3, 38, true))
            {
                return null;
            }

            slot.onSlotChange(itemstack1, itemstack);
        }
        else if (par2 != 1 && par2 != 0)
        {
            if (RitualStoneRecipes.smelting().getSmeltingResult(itemstack1) != null)
            {
                if (!this.mergeItemStack(itemstack1, 0, 1, false))
                {
                    return null;
                }
            }
            else if (TileEntityCobaltFurnace.isItemFuel(itemstack1))
            {
                if (!this.mergeItemStack(itemstack1, 1, 2, false))
                {
                    return null;
                }
            }
            else if (par2 >= 3 && par2 < 30)
            {
                if (!this.mergeItemStack(itemstack1, 30, 38, false))
                {
                    return null;
                }
            }
            else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
            {
                return null;
            }
        }
        else if (!this.mergeItemStack(itemstack1, 3, 38, false))
        {
            return null;
        }

        if (itemstack1.stackSize == 0)
        {
            slot.putStack((ItemStack)null);
        }
        else
        {
            slot.onSlotChanged();
        }

        if (itemstack1.stackSize == itemstack.stackSize)
        {
            return null;
        }

        slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
    }

    return itemstack;
}
}