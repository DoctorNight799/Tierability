package tierability.item.tool.t1_upgraded;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tierability.item.tool.base.CustomAxeItem;
import tierability.util.EffectsUtils;

public class T1UpgradedAxeItem extends CustomAxeItem {
    public T1UpgradedAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity) {
            EffectsUtils.add(attacker, StatusEffects.STRENGTH, 5*20, 0);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(miner instanceof PlayerEntity) {
            EffectsUtils.add(miner, StatusEffects.HASTE, 7*20, 0);
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
