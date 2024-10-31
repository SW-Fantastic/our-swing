package org.swdc.swing.comp;

import org.swdc.swing.Alignment;
import org.swdc.swing.Component;

import javax.swing.*;

public class Label extends Component<JLabel, Label> {

    public Label() {
        super(new JLabel());
    }

    public Label text(String text) {
        component.setText(text);
        return this;
    }

    public Label verticalAlignment(Alignment alignment) {
        switch (alignment) {
            case TOP -> component.setVerticalAlignment(SwingConstants.TOP);
            case BOTTOM -> component.setVerticalAlignment(SwingConstants.BOTTOM);
            case CENTER -> component.setVerticalAlignment(SwingConstants.CENTER);
        }
        return this;
    }

    public Label horizontalAlignment(Alignment alignment) {
        switch (alignment) {
            case LEFT -> component.setHorizontalAlignment(SwingConstants.LEFT);
            case RIGHT -> component.setHorizontalAlignment(SwingConstants.RIGHT);
            case CENTER -> component.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return this;
    }

    public Label image(ImageIcon image) {
        component.setIcon(image);
        return this;
    }

    public Label disableImage(ImageIcon image) {
        component.setDisabledIcon(image);
        return this;
    }

    public Label iconTextGap(int gap) {
        component.setIconTextGap(gap);
        return this;
    }

}
