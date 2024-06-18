package github.killarexe.little_smod.effect;

import eu.pb4.polymer.core.api.other.PolymerStatusEffect;
import github.killarexe.little_smod.LittleSMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

public class RemoteEffect extends StatusEffect implements PolymerStatusEffect {

    private Vec3d position;
    private RegistryKey<World> dimension;
    private LivingEntity entity;

    public RemoteEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x32ffa3);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if(!entity.getWorld().isClient()) {
            position = entity.getPos();
            dimension = entity.getWorld().getRegistryKey();
            this.entity = entity;
        }
    }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        super.onRemoved(attributeContainer);
        ServerWorld world = entity.getWorld().getServer().getWorld(dimension);
        if (world != null) {
            TeleportTarget target = new TeleportTarget(world, position, Vec3d.ZERO, entity.getYaw(), entity.getPitch(), TeleportTarget.NO_OP);
            entity.teleportTo(target);
        }
    }
}
