package com.ayesa;

import org.sonar.api.Plugin;

public class CustomRulesPlugin implements Plugin {
    @Override
    public void define(Context context) {
        context.addExtension(CustomRulesDefinition.class);
        context.addExtension(CustomRulesCheckRegistrar.class);
        context.addExtension(CustomXmlRulesDefinition.class);
    }
}