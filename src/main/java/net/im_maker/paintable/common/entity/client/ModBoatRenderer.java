/*
package net.im_maker.paintable.common.entity.client;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.im_maker.paintable.Paintable;
import net.im_maker.paintable.common.entity.ModBoatEntity;
import net.im_maker.paintable.common.entity.ModChestBoatEntity;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.stream.Stream;

public class ModBoatRenderer extends BoatRenderer {
    private final Map<ModBoatEntity.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public ModBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.shadowRadius = 0.8F;
        this.boatResources = Stream.of(ModBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap((type) -> {
            return type;
        }, (textureLocation) -> {
            return Pair.of(new ResourceLocation(getTextureLocation(textureLocation, pChestBoat)), this.createBoatModel(pContext, textureLocation, pChestBoat));
        }));
    }

    private static String getTextureLocation(ModBoatEntity.Type pType, boolean pChestBoat) {
        return pChestBoat ? "textures/entity/chest_boat/" + pType.getName() + ".png" : "textures/entity/boat/" + pType.getName() + ".png";
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context pContext, ModBoatEntity.Type pType, boolean pChestBoat) {
        ModelLayerLocation modellayerlocation = pChestBoat ? ModBoatRenderer.createChestBoatModelName(pType) : ModBoatRenderer.createBoatModelName(pType);
        return new BoatModel(pContext.bakeLayer(modellayerlocation), pChestBoat);
    }

    public static ModelLayerLocation createBoatModelName(ModBoatEntity.Type pType) {
        return createLocation("boat/" + pType.getName(), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(ModBoatEntity.Type pType) {
        return createLocation("chest_boat/" + pType.getName(), "main");
    }

    private static ModelLayerLocation createLocation(String pPath, String pModel) {
        return new ModelLayerLocation(new ResourceLocation(Paintable.MOD_ID, pPath), pModel);
    }

    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if(boat instanceof ModBoatEntity modBoat) {
            return this.boatResources.get(modBoat.getModVariant());
        } else if(boat instanceof ModChestBoatEntity modChestBoatEntity) {
            return this.boatResources.get(modChestBoatEntity.getModVariant());
        } else {
            return null;
        }
    }
    public Pair<ResourceLocation, BoatModel> getModelWithLocation(ModBoatEntity boat) { return this.boatResources.get(ModBoatEntity.getBoatType()); }

}
*/