package tierability.item.tool.t3_nature;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import tierability.item.tool.base.NatureDaggerItem;
import tierability.util.EffectsUtils;

public class T3NatureDaggerItem extends NatureDaggerItem {
    public T3NatureDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity) {
            EffectsUtils.add(attacker, StatusEffects.SPEED, 6*20, 0);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        EffectsUtils.add(user, StatusEffects.INVISIBILITY, 5*20, 0);
        user.getItemCooldownManager().set(this, 18*20);
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        player.getItemCooldownManager().set(this, 15*20);
        return super.useOnBlock(context);
    }
}
