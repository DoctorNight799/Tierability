package tierability.item.tool.t2_upgraded;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tierability.item.tool.base.CustomPickaxeItem;
import tierability.util.EffectsUtils;

public class T2UpgradedPickaxeItem extends CustomPickaxeItem {
    public T2UpgradedPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(miner instanceof PlayerEntity) {
            EffectsUtils.add(miner, StatusEffects.HASTE, 175, 0);
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
