package github.killarexe.little_smod.registry;

import github.killarexe.little_smod.LittleSMod;
import github.killarexe.little_smod.item.DustItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class LittleSModItems {

    public static final DustItem DUST = registerItem("dust", new DustItem());

    public static <T extends Item> T registerItem(String id, T item) {
        return Registry.register(Registries.ITEM, LittleSMod.id(id), item);
    }

    public static void register() {
    }
}
