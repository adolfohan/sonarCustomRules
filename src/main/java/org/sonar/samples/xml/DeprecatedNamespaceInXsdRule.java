package org.sonar.samples.xml;

import org.sonar.check.Rule;
import org.sonarsource.analyzer.commons.xml.XmlFile;
import org.sonarsource.analyzer.commons.xml.checks.SonarXmlCheck;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.regex.Pattern;

@Rule(key = "DeprecatedNamespaceInXsd")
public class DeprecatedNamespaceInXsdRule extends SonarXmlCheck {

    private static final Pattern DEPRECATED_NAMESPACE_PATTERN = Pattern.compile("targetNamespace=\"http://[^\"]*\\.apps\\.pskb\\.kutxabank\"");

    @Override
    public void scanFile(XmlFile file) {
        Document document = file.getDocument();
        Element root = document.getDocumentElement();
        
        String namespaceAttribute = root.getAttribute("targetNamespace");
        if (DEPRECATED_NAMESPACE_PATTERN.matcher(namespaceAttribute).matches()) {
            reportIssue(root, "This XSD file uses a deprecated PSKB V1 namespace.");
        }
    }
}