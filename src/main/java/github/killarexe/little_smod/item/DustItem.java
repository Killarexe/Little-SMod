package github.killarexe.little_smod.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import github.killarexe.little_smod.LittleSMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;

public class DustItem extends SimplePolymerItem {

    private final int modelData;

    public DustItem() {
        super(new Item.Settings(), Items.COAL);
        this.modelData = PolymerResourcePackUtils.requestModel(Items.COAL, LittleSMod.id("item/dust")).value();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return modelData;
    }
}
