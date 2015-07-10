package cobaltmod.gui;

import cobaltmod.entity.TileEntityAltar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAltar extends Container
{
    private TileEntityAltar altar;
    private int lastCookTime = 0;
    public int lastBurnTime = 0;

    public ContainerAltar(InventoryPlayer par1InventoryPlayer, TileEntityAltar par2TileEntityAltar)
    {
        this.altar = par2TileEntityAltar;
        this.addSlotToContainer(new Slot(par2TileEntityAltar, 0, 36, 35));
        this.addSlotToContainer(new Slot(par2TileEntityAltar, 1, 56, 35));
        this.addSlotToContainer(new SlotAltar(par1InventoryPlayer.player, par2TileEntityAltar, 2, 116, 35));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.altar.furnaceCookTime);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.altar.furnaceCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.altar.furnaceCookTime);
            }
        }

        this.lastCookTime = this.altar.furnaceCookTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.altar.furnaceCookTime = par2;
        }

        if (par1 == 2)
        {
        	
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.altar.isUseableByPlayer(par1EntityPlayer);
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
                    if (!mergeItemStack(itemstack1, 3, 39, true))
                    {
                            return null;
                    }
            }        
            else if (par2 >= 3 && par2 < 30)
            {
                    if (!mergeItemStack(itemstack1, 30, 39, false))
                    {
                            return null;
                    }
            }
            else if (par2 >= 30 && par2 < 39)
            {
                    if (!mergeItemStack(itemstack1, 3, 30, false))
                    {
                            return null;
                    }
            }
            else if (!mergeItemStack(itemstack1, 3, 39, false))
            {
                    return null;
            }
            if (itemstack1.stackSize == 0)
            {
                    slot.putStack(null);
            }
            else
            {
                    slot.onSlotChanged();
            }
            if (itemstack1.stackSize != itemstack.stackSize)
            {
                    slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
            }
            else
            {
                    return null;
            }
        }

        return itemstack;
    }
}
