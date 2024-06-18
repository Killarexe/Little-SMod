package github.killarexe.little_smod.registry;

import github.killarexe.little_smod.LittleSMod;
import github.killarexe.little_smod.item.DustItem;
import github.killarexe.little_smod.item.ExplosiveThrowableStick;
import github.killarexe.little_smod.item.ThrowableStick;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class LittleSModItems {

    public static final DustItem DUST = registerItem("dust", new DustItem());
    public static final ThrowableStick THROWABLE_STICK = registerItem("throwable_stick", new ThrowableStick());
    public static final ExplosiveThrowableStick EXPLOSIVE_THROWABLE_STICK = registerItem("explosive_throwable_stick", new ExplosiveThrowableStick());

    public static <T extends Item> T registerItem(String id, T item) {
        return Registry.register(Registries.ITEM, LittleSMod.id(id), item);
    }

    public static void register() {
    }
}
