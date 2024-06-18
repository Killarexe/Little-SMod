package github.killarexe.little_smod.registry;

import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import github.killarexe.little_smod.LittleSMod;
import github.killarexe.little_smod.entity.ExplosiveStickEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class LittleSModEntities {

    public static final EntityType<ExplosiveStickEntity> EXPLOSIVE_STICK_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            LittleSMod.id("explosive_stick_entity"),
            EntityType.Builder.create(ExplosiveStickEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.25f).build()
    );

    public static void register(){
        PolymerEntityUtils.registerType(EXPLOSIVE_STICK_ENTITY);
    }
}
