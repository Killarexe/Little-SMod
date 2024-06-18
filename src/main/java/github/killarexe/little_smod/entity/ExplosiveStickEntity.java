package github.killarexe.little_smod.entity;

import eu.pb4.polymer.core.api.entity.PolymerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class ExplosiveStickEntity extends ExplosiveProjectileEntity implements PolymerEntity {

    private Vec3d orginalPos;

    public ExplosiveStickEntity(EntityType<? extends ExplosiveProjectileEntity> entityType, World world) {
        super(entityType, world);
        this.orginalPos = Vec3d.ZERO;
    }

    @Override
    public EntityType<?> getPolymerEntityType(ServerPlayerEntity player) {
        return EntityType.ARROW;
    }

    public void setOrginalPos(Vec3d orginalPos) {
        this.orginalPos = orginalPos;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            boolean bl = this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
            float distance = (float)Math.clamp(orginalPos.distanceTo(getPos()) / 10.0D, 0.5D, 10.0D);
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), distance, bl, World.ExplosionSourceType.MOB);
            this.discard();
        }
    }
}
