package net.im_maker.carved_wood.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(BlockEntityType.class)
public interface BlockEntityTypeAccessor {

    @Accessor("validBlocks")
    Set<Block> carvedwood$getValidBlocks();

    @Accessor("validBlocks")
    void carvedwood$setValidBlocks(Set<Block> blocks);
}