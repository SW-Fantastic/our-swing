package org.swdc.swing.containers;

import org.swdc.swing.Component;

import javax.swing.*;

public class Pane extends Component<JPanel, Pane> {

    public Pane() {
        super(new JPanel());
    }

    public Pane add(int x, int y, int width, int height, JComponent component) {
        component.setBounds(x,y,width,height);
        this.component.add(component);
        return this;
    }

    public Pane add(int x, int y, JComponent component) {
        return add(x,y,component.getWidth(),component.getHeight(),component);
    }

    public Pane add(int x, int y,Component component) {
        component.initParent(this);
        return add(x,y,component.getComponent());
    }

    public Pane add(int x, int y, int width, int height, Component component) {
        component.initParent(this);
        return add(x,y,width,height,component.getComponent());
    }

}
