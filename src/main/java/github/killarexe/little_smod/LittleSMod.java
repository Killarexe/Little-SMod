package github.killarexe.little_smod;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import github.killarexe.little_smod.registry.LittleSModItemGroups;
import github.killarexe.little_smod.registry.LittleSModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LittleSMod implements ModInitializer {
    public static final String MOD_ID = "little_smod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Init Little SMod...");
        if (!PolymerResourcePackUtils.addModAssets(LittleSMod.MOD_ID)) {
            LittleSMod.LOGGER.error("Failed to load LittleSMod's assets! Please enable server resource pack!");
        }
        LittleSModItems.register();
        LittleSModItemGroups.register();
    }

    public static Identifier id(String id) {
        return Identifier.of(MOD_ID, id);
    }
}
