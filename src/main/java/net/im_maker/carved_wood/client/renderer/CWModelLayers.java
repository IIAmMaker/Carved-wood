package net.im_maker.carved_wood.client.renderer;

import com.google.common.collect.Sets;
import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Set;

@OnlyIn(Dist.CLIENT)
public class CWModelLayers {
   private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
   public static final ModelLayerLocation CHEST = register("chest");
   public static final ModelLayerLocation DOUBLE_CHEST_LEFT = register("double_chest_left");
   public static final ModelLayerLocation DOUBLE_CHEST_RIGHT = register("double_chest_right");
   public static final ModelLayerLocation CAMPFIRE = register("campfire");

   private static ModelLayerLocation register(String pPath) {
      return register(pPath, "main");
   }

   private static ModelLayerLocation register(String pPath, String pModel) {
      ModelLayerLocation modellayerlocation = createLocation(pPath, pModel);
      if (!ALL_MODELS.add(modellayerlocation)) {
         throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
      } else {
         return modellayerlocation;
      }
   }

   private static ModelLayerLocation createLocation(String pPath, String pModel) {
      return new ModelLayerLocation(new ResourceLocation(CarvedWood.MOD_ID, pPath), pModel);
   }

}
