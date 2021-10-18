package tierability.item.tool.t1_upgraded;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tierability.item.tool.base.BaseDaggerItem;

import java.util.List;

public class T1UpgradedDaggerItem extends BaseDaggerItem {
    public T1UpgradedDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 140));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 100));
        user.getItemCooldownManager().set(this, 220);
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.tierability.dagger.tooltip1"));
        tooltip.add(new TranslatableText("item.tierability.dagger.tooltip2"));
        tooltip.add(new TranslatableText("item.tierability.dagger.tooltip3"));
        tooltip.add(new TranslatableText("item.tierability.dagger.tooltip4"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}