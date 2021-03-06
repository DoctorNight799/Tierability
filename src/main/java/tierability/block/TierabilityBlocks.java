package tierability.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;
import tierability.block.base.*;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class TierabilityBlocks {

    public static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    public static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    public static final Block T1_ORE = add("t1_ore", new BasedBlock( 2, 3.0f, 3.0f));
    public static final Block T2_ORE = add("t2_ore", new BasedBlock(2, 5.0f, 3.0f));
    public static final Block T1_BLOCK = add("t1_block", new BasedBlock(4.0f, 3.0f));
    public static final Block T2_BLOCK = add("t2_block", new BasedBlock(6.0f, 3.0f));
    public static final Block JUMPING_BLOCK_T1 = add("jump_block_t1", new JumpBlock( 2, 2));
    public static final Block JUMPING_BLOCK_T2 = add("jump_block_t2", new JumpBlock(2, 3));
    public static final Block CRAFTING_TIER_BLOCK = add("tiering_block", new CraftingTierBlock( 2));
    public static final Block FLAME_CRYSTAL = add("flame_crystal", new FlameCrystal(2, 4.0f, 6.0f, "flame"));
    public static final Block ELECTRO_CRYSTAL = add("electro_crystal", new ElectroCrystal(2, 4.0f, 8.0f, "electro"));
    public static final Block SOUL_CRYSTAL = add("soul_crystal", new SoulCrystal(2, 6.0f, 6.0f, "soul"));


    private static <B extends Block> B add(String name, B block) {
        Item.Settings settings = new Item.Settings();
        settings.group(TierabilityMod.ITEM_GROUP_BLOCKS);
        return addBlockItem(name, block, new BlockItem(block, settings));
    }

    private static <B extends Block> B addBlockItem(String name, B block, BlockItem item) {
        addBlock(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(new Identifier(TierabilityMod.MODID, name), item);
        }
        return block;
    }

    private static <B extends Block> B addBlock(String name, B block) {
        BLOCKS.put(new Identifier(TierabilityMod.MODID, name), block);
        return block;
    }

    public static void register() {
        ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, ITEMS.get(id)));
        BLOCKS.forEach((id, block) -> Registry.register(Registry.BLOCK, id, BLOCKS.get(id)));
    }

    public static Map<Identifier, Block> getBlocks() {
        return BLOCKS;
    }
}
