package whirlfrenzy.itemdespawntimer.access;

import net.minecraft.server.network.ServerPlayerEntity;

public interface ItemEntityRenderStateAccessInterface {
    boolean item_despawn_timer$getLabelVisibility();

    void item_despawn_timer$setLabelVisibility(boolean visible);

    int item_despawn_timer$getModItemAge();

    void item_despawn_timer$setModItemAge(int itemAge);

    int item_despawn_timer$getModItemLifespan();

    void item_despawn_timer$setModItemLifespan(int itemLifespan);
}
