package com.claudecontent.registry;

import com.claudecontent.ClaudeContent;
import com.claudecontent.worldgen.RootsSanctuaryFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, ClaudeContent.MODID);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ROOTS_SANCTUARY = FEATURES.register(
            "roots_sanctuary", RootsSanctuaryFeature::new);
    private ModFeatures() {}
}
