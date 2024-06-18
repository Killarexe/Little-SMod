package github.killarexe.little_smod.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import github.killarexe.little_smod.LittleSMod;
import github.killarexe.little_smod.entity.ExplosiveStickEntity;
import github.killarexe.little_smod.registry.LittleSModEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ExplosiveThrowableStick extends SimplePolymerItem {

    private final int modelData;

    public ExplosiveThrowableStick() {
        super(new Settings(), Items.STICK);
        this.modelData = PolymerResourcePackUtils.requestModel(Items.STICK, LittleSMod.id("item/explosive_throwable_stick")).value();
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        ExplosiveStickEntity entity = new ExplosiveStickEntity(LittleSModEntities.EXPLOSIVE_STICK_ENTITY, world);
        entity.setPos(user.getX(), user.getEyeY() - 0.10000000149011612, user.getZ());
        entity.setOrginalPos(entity.getPos());
        entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F,  5.0F, 0.0f);
        world.spawnEntity(entity);
        if(!user.isInCreativeMode()) {
            stack.decrement(1);
        }
        return TypedActionResult.success(stack);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
       return modelData;
    }
}
