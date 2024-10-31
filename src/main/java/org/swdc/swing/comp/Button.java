package org.swdc.swing.comp;


import javax.swing.*;

public class Button extends AbstractButton<JButton,Button> {

    public Button() {
        super(new JButton());
    }

    public Button asDefault(boolean val) {
        component.setDefaultCapable(val);
        return this;
    }

}
