package github.killarexe.little_smod.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ThrowableStick extends SimplePolymerItem {
    public ThrowableStick() {
        super(new Item.Settings(), Items.STICK);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        ArrowEntity entity = new ArrowEntity(world, user, stack.copyWithCount(1), stack);
        entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F,  5.0F, 0.0f);
        entity.setDamage(0.01f);
        world.spawnEntity(entity);
        if(!user.isInCreativeMode()) {
            stack.decrement(1);
        }
        return TypedActionResult.success(stack);
    }
}
