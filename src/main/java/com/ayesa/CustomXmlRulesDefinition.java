package com.ayesa;

import java.util.Arrays;

import org.sonar.api.SonarRuntime;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.samples.xml.DeprecatedNamespaceInXsdRule;
import org.sonarsource.analyzer.commons.RuleMetadataLoader;

public class CustomXmlRulesDefinition implements RulesDefinition {
    private static final String RESOURCE_BASE_PATH = "xml/rules";

    @Override
    public void define(Context context) {
        NewRepository repository = context.createRepository("rules", "xml").setName("Custom XML Rules");
        
        RuleMetadataLoader metadataLoader = new RuleMetadataLoader(
            RESOURCE_BASE_PATH,
            (SonarRuntime) CustomXmlRulesDefinition.class.getClassLoader()
        );
        
        metadataLoader.addRulesByAnnotatedClass(repository, Arrays.asList(DeprecatedNamespaceInXsdRule.class));
        
        repository.done();
    }
}