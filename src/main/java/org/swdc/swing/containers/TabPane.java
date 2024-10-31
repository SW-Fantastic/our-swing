package org.swdc.swing.containers;

import org.swdc.swing.Component;

import javax.swing.*;

public class TabPane extends Component<JTabbedPane,TabPane> {

    public TabPane() {
        super(new JTabbedPane());
    }

    public TabPane addTab(String title, JComponent component) {
        this.component.addTab(title,component);
        return this;
    }

    public TabPane addTab(String title, Component component) {
        component.initParent(this);
        return addTab(title,component.getComponent());
    }

    public TabPane title(int index ,String title) {
        component.setTitleAt(index,title);
        return this;
    }

    public TabPane tabComponentAt(int index, JComponent component) {
        this.component.setTabComponentAt(index,component);
        return this;
    }

    public TabPane tabComponentAt(int index, Component component) {
        component.initParent(this);
        return tabComponentAt(index,component.getComponent());
    }

}
