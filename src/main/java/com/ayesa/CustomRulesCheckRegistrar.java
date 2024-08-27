package com.ayesa;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.samples.java.NoFileInstantiationRule;
import java.util.Arrays;

public class CustomRulesCheckRegistrar implements CheckRegistrar {
    @Override
    public void register(RegistrarContext registrarContext) {
        registrarContext.registerClassesForRepository(
            "custom",
            Arrays.asList(NoFileInstantiationRule.class),
            Arrays.asList(NoFileInstantiationRule.class)
        );
    }
}