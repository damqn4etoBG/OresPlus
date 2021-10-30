package net.damqn4etobg.data.recipes;

//import com.google.gson.JsonObject;
//import net.damqn4etobg.oresplus.block.ModBlocks;
//import net.minecraft.inventory.IInventory;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.crafting.IRecipeSerializer;
//import net.minecraft.item.crafting.IRecipeType;
//import net.minecraft.item.crafting.Ingredient;
//import net.minecraft.network.PacketBuffer;
//import net.minecraft.util.NonNullList;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.world.World;
//import net.minecraftforge.registries.ForgeRegistry;
//
//import javax.annotation.Nullable;
//
//public class FusionCrafterRecipe implements IFusionCrafterRecipe{
//
//
//    private final ResourceLocation id;
//    private final ItemStack output;
//    private final NonNullList<Ingredient> recipeItems;
//
//    public FusionCrafterRecipe(ResourceLocation id, ItemStack output,
//                               NonNullList<Ingredient> recipeItems) {
//        this.id = id;
//        this.output = output;
//        this.recipeItems = recipeItems;
//    }
//
//    @Override
//    public boolean matches(IInventory inv, World worldIn) {
//            Checks for correct focus (Water Bucket)
//            if(recipeItems.get(0).test(inv.getStackInSlot(0))) {
//                return recipeItems.get(2).test(inv.getStackInSlot(2));
//            }
//        return false;
//    }
//
//    @Override
//    public NonNullList<Ingredient> getIngredients() {
//        return IFusionCrafterRecipe.super.getIngredients();
//    }
//
//    @Override
//    public ItemStack getCraftingResult(IInventory inv) {
//        return output;
//    }
//
//    @Override
//    public ItemStack getRecipeOutput() {
//        return output.copy();
//    }
//
//    public ItemStack getIcon() {
//        return new ItemStack(ModBlocks.FUSION_CRAFTER.get());
//    }
//
//    @Override
//    public ResourceLocation getId() {
//        return id;
//    }
//
//    @Override
//    public IRecipeSerializer<?> getSerializer() {
//        return null;
//    }
//
//    public static class FusionRecipeType implements IRecipeType<FusionCrafterRecipe> {
//        @Override
//        public String toString() {
//            return FusionCrafterRecipe.TYPE_ID.toString();
//        }
//    }
//
//    public static class Serializer extends ForgeRegistry<IRecipeSerializer<?>>
//            implements IRecipeSerializer<FusionCrafterRecipe> {
//
//        @Override
//        public FusionCrafterRecipe read(ResourceLocation recipeId, JsonObject json) {
//            return null;
//        }
//
//        @Nullable
//        @Override
//        public FusionCrafterRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
//            return null;
//        }
//
//        @Override
//        public void write(PacketBuffer buffer, FusionCrafterRecipe recipe) {
//
//        }
//    }
//}
//