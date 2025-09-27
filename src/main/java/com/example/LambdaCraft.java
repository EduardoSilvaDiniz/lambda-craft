package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;


public class LambdaCraft implements ModInitializer {
  public static final String MOD_ID = "lambda-craft";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
		ModItems.initialize();
    LOGGER.info("Hello Fabric world!");
  }
}
