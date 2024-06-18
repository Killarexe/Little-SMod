package github.killarexe.little_smod.registry;

import eu.pb4.polymer.core.api.other.SimplePolymerPotion;
import github.killarexe.little_smod.LittleSMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class LittleSModPotions {

    public static final SimplePolymerPotion REMOTE_POTION = Registry.register(
            Registries.POTION, LittleSMod.id("remote_potion"),
            new SimplePolymerPotion(new StatusEffectInstance(RegistryEntry.of(LittleSModEffects.REMOTE_EFFECT), 400, 0))
    );

    public static void register() {

    }
}
