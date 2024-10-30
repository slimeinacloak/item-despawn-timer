package whirlfrenzy.itemdespawntimer.mixin;

import net.minecraft.client.render.entity.state.ItemEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import whirlfrenzy.itemdespawntimer.access.ItemEntityRenderStateAccessInterface;

@Mixin(ItemEntityRenderState.class)
public abstract class ItemEntityRenderStateMixin implements ItemEntityRenderStateAccessInterface {
    @Unique
    private boolean item_despawn_timer$labelVisibility;
    @Unique
    private int item_despawn_timer$modItemAge;
    @Unique
    private int item_despawn_timer$modItemLifespan;

    @Override
    public boolean item_despawn_timer$getLabelVisibility(){
        return this.item_despawn_timer$labelVisibility;
    }

    @Override
    public void item_despawn_timer$setLabelVisibility(boolean visible){
        this.item_despawn_timer$labelVisibility = visible;
    }

    @Override
    public int item_despawn_timer$getModItemAge(){
        return this.item_despawn_timer$modItemAge;
    }

    @Override
    public void item_despawn_timer$setModItemAge(int itemAge){
        this.item_despawn_timer$modItemAge = itemAge;
    }

    @Override
    public int item_despawn_timer$getModItemLifespan(){
        return this.item_despawn_timer$modItemLifespan;
    }

    @Override
    public void item_despawn_timer$setModItemLifespan(int itemLifespan){
        this.item_despawn_timer$modItemLifespan = itemLifespan;
    }
}
