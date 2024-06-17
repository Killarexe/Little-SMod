package github.killarexe.little_smod.registry;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import github.killarexe.little_smod.LittleSMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.text.Text;

public class LittleSModItemGroups {

    public static ItemGroup LITTLE_SMOD_GROUP;

    public static void register() {
        LITTLE_SMOD_GROUP = PolymerItemGroupUtils.builder()
            .displayName(Text.translatable(LittleSMod.MOD_ID + "item_group.little_smod_group"))
            .entries((context, entries) -> {
                entries.add(LittleSModItems.DUST.getDefaultStack());
            })
            .icon(LittleSModItems.DUST::getDefaultStack).build();
        PolymerItemGroupUtils.registerPolymerItemGroup(LittleSMod.id("little_smod_group"), LITTLE_SMOD_GROUP);
    }
}
