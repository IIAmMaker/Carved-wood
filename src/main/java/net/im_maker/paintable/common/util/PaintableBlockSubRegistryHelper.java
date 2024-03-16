package net.im_maker.paintable.common.util;


import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public class PaintableBlockSubRegistryHelper extends BlockSubRegistryHelper {

    public PaintableBlockSubRegistryHelper(RegistryHelper parent) {
        super(parent, parent.getItemSubHelper().getDeferredRegister(), parent.getBlockSubHelper().getDeferredRegister());
    }

    public <B extends Block> RegistryObject<B> createWallOrVerticalBlock(String name, String wallName, Supplier<? extends B> supplier, Supplier<? extends B> wallSupplier, @Nullable CreativeModeTab group) {
        RegistryObject<B> block = this.deferredRegister.register(wallName, wallSupplier);
        return block;
    }
}
