package net.im_maker.carved_wood.datagen;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.CWBlocks;
import net.im_maker.carved_wood.common.tags.CWTags;
import net.im_maker.carved_wood.common.util.CWPoiType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTagGenerator extends PoiTypeTagsProvider {
    public ModPoiTypeTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture,
                                  @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, CarvedWood.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(PoiTypeTags.BEE_HOME).add(
                CWPoiType.BEEHIVE.getKey()
        );
    }
}