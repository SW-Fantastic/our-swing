package org.swdc.swing.containers;

import org.swdc.swing.Component;

import javax.swing.*;

public class VBoxPane extends Component<JPanel, VBoxPane> {

    private BoxLayout layout;

    public VBoxPane() {
        super(new JPanel());
        layout = new BoxLayout(component,BoxLayout.Y_AXIS);
        component.setLayout(layout);
    }

    public VBoxPane add(JComponent component) {
        this.component.add(component);
        return this;
    }

    public VBoxPane add(Component component) {
        component.initParent(this);
        return add(component.getComponent());
    }

    public VBoxPane addFixedGap(int height) {
        component.add(Box.createVerticalStrut(height));
        return this;
    }

    public VBoxPane addGap() {
        component.add(Box.createVerticalGlue());
        return this;
    }

}
