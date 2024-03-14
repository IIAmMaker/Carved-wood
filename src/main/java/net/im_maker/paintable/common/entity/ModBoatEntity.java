/*

package net.im_maker.paintable.common.entity;


import net.im_maker.paintable.common.block.ModBlocks;
import net.im_maker.paintable.common.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ModBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_TO_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public ModBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public  ModBoatEntity(Level level, double pX, double pY, double pZ) {
        this (ModEntities.Mod_Boat.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    };

    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case RED_PAINTED -> ModItems.RED_PAINTED_SIGN.get();
        };
    }

    public void setVariant(Type type) {
        this.entityData.get(DATA_TO_TYPE);
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(DATA_TO_TYPE));
    }

    public Boat.Type getBoatType() {
        return Boat.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TO_TYPE, Type.RED_PAINTED.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(Type.byName(pCompound.getString("Type")));
        }
    }


    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setType(Boat.Type.byName(pCompound.getString("Type")));
        }

    }

    public static enum Type {
        RED_PAINTED(ModBlocks.RED_PAINTED_PLANKS.get(), "red_painted");

        private final String name;
        private final Block planks;

        private Type(Block pPlanks, String pName) {
            this.name = pName;
            this.planks = pPlanks;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static Type byId(int pId) {
            Type[] aboat$type = values();
            if (pId < 0 || pId >= aboat$type.length) {
                pId = 0;
            }

            return aboat$type[pId];
        }

        public static Type byName(String pName) {
            Type[] aboat$type = values();

            for(int i = 0; i < aboat$type.length; ++i) {
                if (aboat$type[i].getName().equals(pName)) {
                    return aboat$type[i];
                }
            }

            return aboat$type[0];
        }
    }
}
 */