package org.swdc.swing.comp;

import org.swdc.swing.Component;

import javax.swing.*;

public class MenuItem extends Component<JMenuItem,MenuItem> {

    public MenuItem() {
        super(new JMenuItem());
        component.addActionListener(mouseAdapter());
    }

    public MenuItem text(String text) {
        component.setText(text);
        return this;
    }

    public MenuItem image(ImageIcon image) {
        component.setIcon(image);
        return this;
    }

}
