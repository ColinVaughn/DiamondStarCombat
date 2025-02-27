package com.onewhohears.dscombat.data.tag;

import org.jetbrains.annotations.Nullable;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.init.ModTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagGen extends BlockTagsProvider {

	public BlockTagGen(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
		super(generator, DSCombatMod.MODID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
		tag(ModTags.Blocks.FRAGILE)
			.addTag(Tags.Blocks.GLASS_PANES)
			.addTag(Tags.Blocks.GLASS)
			.addTag(BlockTags.CANDLES)
			.add(Blocks.LILY_PAD)
			.add(Blocks.COCOA)
			.add(Blocks.END_ROD)
			.add(Blocks.SCAFFOLDING)
			.add(Blocks.SEA_PICKLE)
			.add(Blocks.TURTLE_EGG)
			.add(Blocks.GLOWSTONE)
			.add(Blocks.SEA_LANTERN)
			.add(Blocks.ICE)
			.add(Blocks.BLUE_ICE)
			.add(Blocks.FROSTED_ICE)
			.add(Blocks.PACKED_ICE)
			.add(Blocks.BAMBOO)
			.add(Blocks.SMALL_AMETHYST_BUD)
			.add(Blocks.MEDIUM_AMETHYST_BUD)
			.add(Blocks.LARGE_AMETHYST_BUD)
			.add(Blocks.AMETHYST_CLUSTER)
			.add(Blocks.LANTERN)
			.add(Blocks.SOUL_LANTERN)
			.add(Blocks.POINTED_DRIPSTONE);
		tag(ModTags.Blocks.ABSORBENT)
			.add(Blocks.HAY_BLOCK, Blocks.SLIME_BLOCK, Blocks.HONEY_BLOCK);
	}

}
