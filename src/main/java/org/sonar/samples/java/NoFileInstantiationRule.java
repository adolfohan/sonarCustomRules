package org.sonar.samples.java;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;

@Rule(key = "NoFileInstantiation")
public class NoFileInstantiationRule extends BaseTreeVisitor implements JavaFileScanner {

    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitNewClass(NewClassTree tree) {
        if (tree.symbolType().is("java.io.File")) {
            context.reportIssue(this, tree, "El uso de la clase java.io.File no está permitido. Para acceder a ficheros, usar la clase PSKBFileManager");
        }
        super.visitNewClass(tree);
    }
}