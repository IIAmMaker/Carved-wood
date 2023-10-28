package net.teamsoulcrystal.wallpapers.common.block.wallpaper_blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.teamsoulcrystal.wallpapers.common.block.block_values.Baseboard;
import net.teamsoulcrystal.wallpapers.common.block.block_values.ModBlockStateProperties;

public class WallpaperBlock extends Block {
    public static final EnumProperty<Baseboard> BASEBOARD = ModBlockStateProperties.BASEBOARD;

    public WallpaperBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BASEBOARD, Baseboard.NONE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BASEBOARD);
    }
}