package com.ayesa;

import org.sonar.api.rule.RuleStatus;
import org.sonar.api.rule.Severity;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;

public class CustomRulesDefinition implements RulesDefinition {
    @Override
    public void define(Context context) {
        NewRepository repository = context.createRepository("custom", "java").setName("Custom Repository");

        repository.createRule("NoFileInstantiation")
            .setName("No File Instantiation")
            .setHtmlDescription("Do not instantiate java.io.File directly.")
            .setType(RuleType.CODE_SMELL)
            .setSeverity(Severity.MAJOR)
            .setStatus(RuleStatus.READY);

        repository.createRule("DeprecatedNamespaceInXsd")
            .setName("Deprecated Namespace in XSD")
            .setHtmlDescription("XSD files should not use deprecated PSKB V1 namespace.")
            .setType(RuleType.CODE_SMELL)
            .setSeverity(Severity.MAJOR)
            .setStatus(RuleStatus.READY);

        repository.done();
    }
}