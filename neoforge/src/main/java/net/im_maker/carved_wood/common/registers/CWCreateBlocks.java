package net.im_maker.carved_wood.common.registers;

import net.im_maker.carved_wood.common.block.CWLecternControllerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class CWCreateBlocks {
    public static final Block SPRUCE = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(2.5F), CWBlocks.SPRUCE_LECTERN);
    public static final Block BIRCH = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(2.5F), CWBlocks.BIRCH_LECTERN);
    public static final Block JUNGLE = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(2.5F), CWBlocks.JUNGLE_LECTERN);
    public static final Block ACACIA = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(2.5F), CWBlocks.ACACIA_LECTERN);
    public static final Block DARK_OAK = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(2.5F), CWBlocks.DARK_OAK_LECTERN);
    public static final Block MANGROVE = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(2.5F), CWBlocks.MANGROVE_LECTERN);
    public static final Block CHERRY = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(2.5F), CWBlocks.CHERRY_LECTERN);
    public static final Block PALE_OAK = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5F), CWBlocks.PALE_OAK_LECTERN);
    public static final Block CRIMSON = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(2.5F), CWBlocks.CRIMSON_LECTERN);
    public static final Block WARPED = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(2.5F), CWBlocks.WARPED_LECTERN);
    public static final Block BAMBOO = new CWLecternControllerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(2.5F), CWBlocks.BAMBOO_LECTERN);
}