package com.teamabnormals.upgrade_aquatic.core.mixin;

import com.teamabnormals.upgrade_aquatic.common.item.GlowingInkItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Squid.class)
public abstract class SquidMixin extends Entity {

	private SquidMixin(EntityType<?> entityTypeIn, Level worldIn) {
		super(entityTypeIn, worldIn);
	}

	@Inject(at = @At("HEAD"), method = "spawnInk")
	private void spawnInk(CallbackInfo info) {
		GlowingInkItem.createEffectCloud(new MobEffectInstance(MobEffects.BLINDNESS, 100), this.level, this.getBoundingBox().expandTowards(2.5F, 2.5F, 2.5F));
	}
}
