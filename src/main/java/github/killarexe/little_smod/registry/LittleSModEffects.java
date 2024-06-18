package github.killarexe.little_smod.registry;

import github.killarexe.little_smod.LittleSMod;
import github.killarexe.little_smod.effect.RemoteEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class LittleSModEffects {
    public static final RemoteEffect REMOTE_EFFECT = Registry.register(Registries.STATUS_EFFECT, LittleSMod.id("remote"), new RemoteEffect());

    public static void register() {
    }
}
