package org.swdc.swing.comp;

import org.swdc.swing.Alignment;

import javax.swing.*;

public class Field extends AbstractText<JTextField, Field> {

    public Field() {
        super(new JTextField());
    }

    public Field horizontalAlignment(Alignment alignment) {
        switch (alignment) {
            case LEFT -> component.setHorizontalAlignment(SwingConstants.LEFT);
            case RIGHT -> component.setHorizontalAlignment(SwingConstants.RIGHT);
            case CENTER -> component.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return this;
    }

    public Field editable(boolean val) {
        component.setEditable(val);
        return this;
    }

}
