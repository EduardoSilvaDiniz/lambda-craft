package com.example;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class CustomSounds {
    private CustomSounds() {
    }

   public static final SoundEvent SANDVICH_SOUND = CustomSounds.registerSound(ModItems.SANDVICH_ID);


   public static SoundEvent registerSound(String id) {
       Identifier identifier = Identifier.of(LambdaCraft.MOD_ID, id);
       return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
   }

   public static void initialize() {
       LambdaCraft.LOGGER.info("RegistryLog: " + LambdaCraft.MOD_ID + " Sounds");
   }
}
