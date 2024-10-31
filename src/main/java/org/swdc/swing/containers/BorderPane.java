package org.swdc.swing.containers;

import org.swdc.swing.Component;

import javax.swing.*;
import java.awt.*;

public class BorderPane extends org.swdc.swing.Component<JPanel, BorderPane> {

    private BorderLayout borderLayout;

    public BorderPane() {

        super(new JPanel());
        borderLayout = new BorderLayout();
        component.setLayout(borderLayout);

    }

    public BorderPane gapX(int x) {
        borderLayout.setHgap(x);
        return this;
    }

    public BorderPane gapY(int y) {
        borderLayout.setVgap(y);
        return this;
    }

    public BorderPane left(org.swdc.swing.Component component) {
        component.initParent(this);
        return left(component.getComponent());
    }

    public BorderPane left(JComponent comp) {
        this.component.add(comp,BorderLayout.WEST);
        return this;
    }

    public BorderPane right(org.swdc.swing.Component component) {
        component.initParent(this);
        return right(component.getComponent());
    }

    public BorderPane right(JComponent comp) {
        this.component.add(comp,BorderLayout.EAST);
        return this;
    }

    public BorderPane top(org.swdc.swing.Component component) {
        component.initParent(this);
        return this.top(component.getComponent());
    }

    public BorderPane top(JComponent comp) {
        this.component.add(comp, BorderLayout.NORTH);
        return this;
    }

    public BorderPane bottom(Component component) {
        component.initParent(this);
        return bottom(component.getComponent());
    }

    public BorderPane bottom(JComponent comp) {
        this.component.add(comp,BorderLayout.SOUTH);
        return this;
    }

    public BorderPane center(JComponent comp) {
        this.component.add(comp,BorderLayout.CENTER);
        return this;
    }

    public BorderPane center(Component component) {
        component.initParent(this);
        return center(component.getComponent());
    }

}
