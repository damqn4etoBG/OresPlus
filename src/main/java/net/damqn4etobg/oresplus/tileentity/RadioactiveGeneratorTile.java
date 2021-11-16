package net.damqn4etobg.oresplus.tileentity;

import net.damqn4etobg.energy.CustomEnergyStorage;
import net.damqn4etobg.oresplus.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RadioactiveGeneratorTile extends TileEntity implements ITickable {

    private final ItemStackHandler itemHandler = createHandler();
    private final CustomEnergyStorage energyStorage = createEnergyStorage();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(()-> itemHandler);
    private final LazyOptional<IEnergyStorage> energyHandler = LazyOptional.of(() -> energyStorage);

    private int tick = 0;



    public RadioactiveGeneratorTile()
    {
        this(ModTileEntities.RADIOACTIVE_GENERATOR_TILE.get());
    }

    public RadioactiveGeneratorTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    private CustomEnergyStorage createEnergyStorage() {
        return new CustomEnergyStorage(10000, 0) {
            @Override
            protected void onEnergyChanged()
            {
                onLoad();
            }
        };
    }

    @Override
    public void onLoad() {
        super.onLoad();
        handler.invalidate();
        energyHandler.invalidate();
    }

    @Override
    public void tick()
    {
        tick++;
        if(tick > 10) // should be configurable
        {
            if(this.itemHandler.getStackInSlot(0).getItem() == ModItems.URANIUM_INGOT.get() && this.energyStorage.getEnergyStored() < 64)
            {
                itemHandler.extractItem(0, 1, false);
                energyStorage.generatePower(10);
            }

            tick = 0;
        }
    }


    public void read(BlockState state, CompoundNBT tag)

    {
        itemHandler.deserializeNBT(tag.getCompound("inv"));
        energyStorage.deserializeNBT(tag.getCompound("energy"));

        tick = tag.getInt("counter");
        super.read(state,tag);
    }

    public CompoundNBT write(CompoundNBT tag)
    {
        tag.put("inv", itemHandler.serializeNBT());
        tag.put("energy", energyStorage.serializeNBT());

        tag.putInt("counter", tick);
        return super.write(tag);
    }

    private ItemStackHandler createHandler()
    {
        return new ItemStackHandler(1)
        {
            @Override
            protected void onContentsChanged(int slot)
            {
                onLoad();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack)
            {
                switch (slot)
                {
                    case 0:
                        return stack.getItem() == ModItems.URANIUM_INGOT.get();
                    default:
                        return false;

                }
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
            {
                if(!isItemValid(slot, stack))
                {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    public <T> LazyOptional<T> getCapability (@Nonnull Capability<T> capability, @Nullable Direction side)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return handler.cast();
        }

        else if(capability == CapabilityEnergy.ENERGY)

        {
            return energyHandler.cast();
        }
        return super.getCapability(capability, side);
    }

}
