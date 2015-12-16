package cobaltmod.gui.inventory;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cobaltmod.main.items.ItemBlueBackpack;

public class InventoryBackpack implements IInventory {

	
	private String name = "Blue Backpack";
	
	protected String uniqueID;
	
	private final ItemStack invItem;
	
	public static final int INV_SIZE = 16;

	private ItemStack[] inventory = new ItemStack[INV_SIZE];
	
	
	public InventoryBackpack(ItemStack stack) {
		
		uniqueID = "";
		this.invItem = stack;
		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
			
			uniqueID = UUID.randomUUID().toString();
			
		}
		readFromNBT(stack.getTagCompound());
	}
	
	
	@Override
	public int getSizeInventory() {

		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		
		ItemStack stack = getStackInSlot(slot);
		if(stack != null)
		{
			if(stack.stackSize > amount)
			{
				stack = stack.splitStack(amount);
				// Don't forget this line or your inventory will not be saved!
				this.markDirty();
			}
			else
			{
				// this method also calls onInventoryChanged, so we don't need to call it again
				this.setInventorySlotContents(slot, null);
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			this.setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		
		inventory[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
			
		}
		this.markDirty();
	}


	@Override
	public String getInventoryName() {
		
		return name;
	}

	@Override
	public boolean hasCustomInventoryName() {
		
		return name.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		
		return 64;
	}

	@Override
	public void markDirty() {
		
		for (int i = 0; i < getSizeInventory(); i++) {
			
			if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0) {
				inventory[i] = null;
			}
		}
		this.writeToNBT(invItem.getTagCompound());
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		
		ItemStack[] armor = player.inventory.armorInventory;
		
		if (player.getHeldItem() == invItem) {
			return  true;
		}
		else if(armor[2] != null) {
	    	Item item = armor[2].getItem();
	    	if(item instanceof ItemArmor) 
	    	{
	    		ItemArmor itemA = (ItemArmor) item;
	    		if(itemA.getArmorMaterial() == CMMain.BackpackArmor || item == CMContent.cobaltplatebackpack) 
	    		{	  
	    			return true;
	    		}
	    	}
	    } 
		else {
			return false;
		}
		return false;

	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		
		return !(itemstack.getItem() instanceof ItemBlueBackpack);
	}
	
	public void readFromNBT(NBTTagCompound compound)
	{
		// Gets the custom taglist we wrote to this compound, if any
		// 1.7.2 change to compound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);
		NBTTagList items = compound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);

		for (int i = 0; i < items.tagCount(); ++i)
		{
			// 1.7.2 change to items.getCompoundTagAt(i)
			NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(i);
			int slot = item.getByte("Slot");

			// Just double-checking that the saved slot index is within our inventory array bounds
			if (slot >= 0 && slot < getSizeInventory()) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(item);
			}
		}
		if ("".equals(uniqueID))
		{
			// try to read unique ID from NBT
			uniqueID = compound.getString("uniqueID");
			// if it's still "", assign a new one:
			if ("".equals(uniqueID))
			{
				uniqueID = UUID.randomUUID().toString();
			}
		}
	}
	public void writeToNBT(NBTTagCompound tagcompound)
	{
		// Create a new NBT Tag List to store itemstacks as NBT Tags
		NBTTagList items = new NBTTagList();

		for (int i = 0; i < getSizeInventory(); ++i)
		{
			// Only write stacks that contain items
			if (getStackInSlot(i) != null)
			{
				// Make a new NBT Tag Compound to write the itemstack and slot index to
				NBTTagCompound item = new NBTTagCompound();
				item.setInteger("Slot", i);
				// Writes the itemstack in slot(i) to the Tag Compound we just made
				getStackInSlot(i).writeToNBT(item);

				// add the tag compound to our tag list
				items.appendTag(item);
			}
		}
		// Add the TagList to the ItemStack's Tag Compound with the name "ItemInventory"
		tagcompound.setTag("ItemInventory", items);
		tagcompound.setString("uniqueID", this.uniqueID);
	}
	
	

}
