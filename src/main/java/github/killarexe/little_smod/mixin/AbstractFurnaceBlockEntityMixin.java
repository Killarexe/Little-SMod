package github.killarexe.little_smod.mixin;

import github.killarexe.little_smod.LittleSMod;
import github.killarexe.little_smod.registry.LittleSModItems;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {

    private static final float CHANCE = 2.0f / 3.0f;

    @Inject(method = "Lnet/minecraft/block/entity/AbstractFurnaceBlockEntity;craftRecipe(Lnet/minecraft/registry/DynamicRegistryManager;Lnet/minecraft/recipe/RecipeEntry;Lnet/minecraft/util/collection/DefaultedList;I)Z", at = @At("RETURN"))
    private static void craftRecipe(DynamicRegistryManager manager, @Nullable RecipeEntry<?> entry, DefaultedList<ItemStack> slots, int count, CallbackInfoReturnable<Boolean> callback) {
        if(callback.getReturnValue() && slots.get(2).getCount() <= 1 && new Random().nextFloat() < CHANCE) {
            slots.set(2, new ItemStack(LittleSModItems.DUST));
        }
    }
}
