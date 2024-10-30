package whirlfrenzy.itemdespawntimer.access;

import net.minecraft.server.network.ServerPlayerEntity;

public interface ItemEntityAccessInterface extends ItemEntityRenderStateAccessInterface {
    void item_despawn_timer$sendItemAgePacket(ServerPlayerEntity player);

    void item_despawn_timer$sendItemAgePacketToNearbyPlayers();

    void item_despawn_timer$sendItemLifespanPacket(ServerPlayerEntity player);

    void item_despawn_timer$sendItemLifespanPacketToNearbyPlayers();

    int item_despawn_timer$getOverriddenLifespanOrModItemLifespan();
}
