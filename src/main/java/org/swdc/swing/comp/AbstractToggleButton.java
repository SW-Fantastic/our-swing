package org.swdc.swing.comp;

import javax.swing.*;

public class AbstractToggleButton<T extends JToggleButton, S extends AbstractToggleButton> extends AbstractButton<T,S> {

    public AbstractToggleButton(T component) {
        super(component);
    }

}
