package whirlfrenzy.itemdespawntimer.mixin;

import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.entity.state.ItemEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whirlfrenzy.itemdespawntimer.access.ItemEntityAccessInterface;
import whirlfrenzy.itemdespawntimer.access.ItemEntityRenderStateAccessInterface;
import whirlfrenzy.itemdespawntimer.rendering.LabelRenderer;

// Priority is set to 999 (one below the default) to still render the labels in case any mods use ci.cancel() (such as Item Physic Full and Lite)
// Higher priorities get added first and thus my mixin should be added after Item Physic's mixin and end up above it
@Mixin(value = ItemEntityRenderer.class, priority = 999)
public abstract class ItemEntityRendererMixin {
    @Inject(at = @At(value = "HEAD"), method = "render(Lnet/minecraft/client/render/entity/state/ItemEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V")
    public void renderTextLabels(ItemEntityRenderState itemEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int lightLevel, CallbackInfo ci) {
        LabelRenderer.renderTextLabels(itemEntityRenderState, matrixStack, vertexConsumerProvider, lightLevel);
    }

    @Inject(method = "updateRenderState(Lnet/minecraft/entity/ItemEntity;Lnet/minecraft/client/render/entity/state/ItemEntityRenderState;F)V", at = @At("TAIL"))
    public void injectDataIntoRenderState(ItemEntity itemEntity, ItemEntityRenderState itemEntityRenderState, float f, CallbackInfo ci){
        ((ItemEntityRenderStateAccessInterface)itemEntityRenderState).item_despawn_timer$setLabelVisibility(((ItemEntityAccessInterface)itemEntity).item_despawn_timer$getLabelVisibility());
        ((ItemEntityRenderStateAccessInterface)itemEntityRenderState).item_despawn_timer$setModItemAge(((ItemEntityAccessInterface)itemEntity).item_despawn_timer$getModItemAge());
        ((ItemEntityRenderStateAccessInterface)itemEntityRenderState).item_despawn_timer$setModItemLifespan(((ItemEntityAccessInterface)itemEntity).item_despawn_timer$getOverriddenLifespanOrModItemLifespan());
    }
}
