package org.swdc.swing.comp;

import org.swdc.swing.Component;

import javax.swing.*;

public class Menu extends Component<JPopupMenu,Menu> {

    public Menu() {
        super(new JPopupMenu());
    }

    public Menu addItem(JMenuItem item) {
        component.add(item);
        return this;
    }

    public Menu addChild(JPopupMenu menu) {
        component.add(menu);
        return this;
    }

    public Menu addItem(MenuItem item) {
        item.initParent(this);
        return addItem(item.getComponent());
    }

    public Menu addChild(Menu menu) {
        menu.initParent(this);
        return addChild(menu.getComponent());
    }

    public Menu addSeparator() {
        component.addSeparator();
        return this;
    }

}
