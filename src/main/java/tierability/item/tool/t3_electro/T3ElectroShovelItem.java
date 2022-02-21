package tierability.item.tool.t3_electro;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tierability.effect.TierabilityEffects;
import tierability.item.tool.base.CustomShovelItem;
import tierability.util.EffectsUtils;

public class T3ElectroShovelItem extends CustomShovelItem {
    public T3ElectroShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EffectsUtils.add(target, TierabilityEffects.ELECTRICITY_EFFECT, 5*20, 0);
        EffectsUtils.add(target, TierabilityEffects.PARALYSE_EFFECT, 4*20, 0);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(miner instanceof PlayerEntity) {
            EffectsUtils.add(miner, StatusEffects.HASTE, 2*20, 1);
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}