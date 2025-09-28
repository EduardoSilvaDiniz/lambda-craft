package com.example;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sandvich extends Item {

    public Sandvich(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack result = super.finishUsing(stack, world, user);
        Identifier identifier = ModItems.SANDVICH_ID_IDENTIFIER;

        if (!world.isClient && user instanceof PlayerEntity player) {
            world.playSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    CustomSounds.SANDVICH_SOUND,
                    SoundCategory.PLAYERS,
                    1.0f,
                    1.0f
            );

        }
        return result;
    }

}
