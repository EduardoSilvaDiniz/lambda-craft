package com.example;

import com.google.common.base.Function;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

public class ModItems {

  public static final Item CROWBAR =
      ModItems.register(
          "crowbar", Item::new, new Item.Settings().sword(ToolMaterial.IRON, 5f, 2f));

  public static final ConsumableComponent POISON_FOOD_CONSUMABLE_COMPONENT =
      ConsumableComponents.food()
          .consumeEffect(
              new ApplyEffectsConsumeEffect(
                  new StatusEffectInstance(StatusEffects.SATURATION, 6 * 20, 1), 1.0f))
          .build();

  public static final FoodComponent POISON_FOOD_COMPONENT =
      new FoodComponent.Builder().alwaysEdible().build();

  public static final Item SANDVICH =
      ModItems.register(
          "sandvich",
          Item::new,
          new Item.Settings().food(POISON_FOOD_COMPONENT, POISON_FOOD_CONSUMABLE_COMPONENT));

  public static Item register(
      String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {

    RegistryKey<Item> itemKey =
        RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LambdaCraft.MOD_ID, name));

    Item item = itemFactory.apply(settings.registryKey(itemKey));
    Registry.register(Registries.ITEM, itemKey, item);

    return item;
  }

  public static void initialize() {
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
        .register(itemGroup -> itemGroup.add(CROWBAR));

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
        .register(itemGroup -> itemGroup.add(SANDVICH));
  }
}
