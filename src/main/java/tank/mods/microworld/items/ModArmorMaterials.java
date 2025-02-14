package tank.mods.microworld.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.function.Supplier;
import java.util.logging.Logger;

import tank.mods.microworld.MicroworldMod;

public enum ModArmorMaterials implements ArmorMaterial {

    BEDROCK("bedrock", 260, new int[]{ 9, 9, 9, 9 }, 95,
            SoundEvents.ARMOR_EQUIP_GOLD, 8f, 3f, () -> Ingredient.of(ModItems.bedroсk_piece.get())),

    CHITIN("chitin", 26, new int[]{ 1, 4, 8, 8 }, 85,
            SoundEvents.ARMOR_EQUIP_GOLD, 1f, 0f, () -> Ingredient.of(ModItems.bedroсk_piece.get())),

    CILLIARY("cilliary", 12, new int[]{ 2, 2, 2, 2 }, 85,
            SoundEvents.ARMOR_EQUIP_GOLD, 1f, 0f, () -> Ingredient.of(ModItems.bedroсk_piece.get())),

    FLEX("flex", 26, new int[]{ 3, 3, 3, 3 }, 95,
            SoundEvents.ARMOR_EQUIP_GOLD, 2f, 0f, () -> Ingredient.of(ModItems.bedroсk_piece.get())),
    STICKY("sticky", 100, new int[]{ 4, 4, 4, 4 }, 85,
            SoundEvents.ARMOR_EQUIP_GOLD, 2f, 0f, () -> Ingredient.of(ModItems.bedroсk_piece.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        Logger.getGlobal().info(MicroworldMod.MODID + ":" + this.name);
        return MicroworldMod.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}