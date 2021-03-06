package zmaster587.blimps.item;

import java.util.List;

import zmaster587.blimps.tileEntity.TileEntityLoadingDock;
import zmaster587.libVulpes.interfaces.ILinkableTile;
import zmaster587.libVulpes.tile.IMultiblock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemLinker extends Item {

	protected int linkX,linkY,linkZ, dimId;
	private final static int EMPTYSETTING = 0;

	public ItemLinker() {
		super();

		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabTransport);
		dimId = 0;
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		int y = getMasterY(par1ItemStack);

		if(y == 0){
			par3List.add("Coords unset!");
		}
		else {
			par3List.add("X: " + getMasterX(par1ItemStack));
			par3List.add("Y: " + getMasterY(par1ItemStack));
			par3List.add("Z: " + getMasterZ(par1ItemStack));
		}
	}

	public static int getMasterX(ItemStack itemStack) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		nbt = nbt.getCompoundTag("MasterPos");

		return nbt.getInteger("MasterX");
	}
	public static int getMasterY(ItemStack itemStack) {
		NBTTagCompound nbt = itemStack.getTagCompound();

		if(nbt == null)
			return 0;

		nbt = nbt.getCompoundTag("MasterPos");

		return nbt.getInteger("MasterY");
	}
	public static int getMasterZ(ItemStack itemStack) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		nbt = nbt.getCompoundTag("MasterPos");

		return nbt.getInteger("MasterZ");
	}
	
	public static void setMasterX(ItemStack itemStack, int num) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		nbt = nbt.getCompoundTag("MasterPos");
		
		nbt.setInteger("MasterX", num);
	}
	
	public static void setMasterY(ItemStack itemStack, int num) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		nbt = nbt.getCompoundTag("MasterPos");
		
		nbt.setInteger("MasterY", num);
	}
	
	public static void setMasterZ(ItemStack itemStack, int num) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		nbt = nbt.getCompoundTag("MasterPos");
		
		nbt.setInteger("MasterZ", num);
	}

	public static void resetPosition(ItemStack itemStack) {
		NBTTagCompound position = new NBTTagCompound();

		position.setInteger("MasterX", EMPTYSETTING);
		position.setInteger("MasterY", EMPTYSETTING);
		position.setInteger("MasterZ", EMPTYSETTING);

		itemStack.setTagInfo("MasterPos", position);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		TileEntity entity = world.getTileEntity(par4, par5, par6);

		if(entity != null) {
			if(entity instanceof ILinkableTile) {
				applySettings(itemStack, (ILinkableTile)entity, player, world);
				return true;
			}
		}
		return false;
	}

	protected void applySettings(ItemStack itemStack, ILinkableTile pad, EntityPlayer player, World world) {
		if(getMasterY(itemStack) == 0) 
			pad.onLinkStart(itemStack, (TileEntity)pad, player, world);
		else
			pad.onLinkComplete(itemStack, (TileEntity)pad, player, world);
	}
}
