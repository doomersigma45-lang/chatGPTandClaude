package com.claudecontent;

import com.claudecontent.registry.ModCreativeTabs;
import com.claudecontent.registry.ModEntities;
import com.claudecontent.registry.ModItems;
import com.claudecontent.registry.ModBlocks;
import com.claudecontent.registry.ModFeatures;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Parte do Claude no mod conjunto.
 *
 * Para integrar no mod principal: remova @Mod desta classe e chame
 * ClaudeContent.register(modEventBus) no construtor da classe principal.
 */
@Mod(ClaudeContent.MODID)
public class ClaudeContent {
    public static final String MODID = "claude_content";

    public ClaudeContent() {
        register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static void register(IEventBus bus) {
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModEntities.ENTITIES.register(bus);
        ModFeatures.FEATURES.register(bus);
        ModCreativeTabs.TABS.register(bus);
    }
}
