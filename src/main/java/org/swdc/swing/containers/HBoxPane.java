package org.swdc.swing.containers;

import org.swdc.swing.Component;

import javax.swing.*;

public class HBoxPane extends Component<JPanel,HBoxPane> {

    private BoxLayout boxLayout;

    public HBoxPane() {
        super(new JPanel());
        this.boxLayout = new BoxLayout(
                component,BoxLayout.X_AXIS
        );
        this.component.setLayout(boxLayout);
    }

    public HBoxPane add(JComponent component) {
        this.component.add(component);
        return this;
    }

    public HBoxPane add(Component component) {
        component.initParent(this);
        return add(component.getComponent());
    }

    public HBoxPane addFixedGap(int width) {
        component.add(Box.createHorizontalStrut(width));
        return this;
    }

    public HBoxPane addGap() {
        component.add(Box.createHorizontalGlue());
        return this;
    }


}
