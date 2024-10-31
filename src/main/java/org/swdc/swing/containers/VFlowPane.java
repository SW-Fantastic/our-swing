package org.swdc.swing.containers;

import org.swdc.swing.Alignment;
import org.swdc.swing.Component;

import javax.swing.*;

public class VFlowPane extends Component<JPanel,VFlowPane> {

    private VerticalFlowLayout layout;

    public VFlowPane() {
        super(new JPanel());
        layout = new VerticalFlowLayout();
        component.setLayout(layout);
    }

    public VFlowPane gapX(int gap) {
        layout.setHGap(gap);
        return this;
    }

    public VFlowPane gapY(int gap) {
        layout.setVGap(gap);
        return this;
    }

    public VFlowPane horizontalAlignment(Alignment alignment) {
        switch (alignment) {
            case LEFT -> layout.setHAlign(VerticalFlowLayout.LEFT);
            case CENTER -> layout.setHAlign(VerticalFlowLayout.CENTER);
            case RIGHT -> layout.setHAlign(VerticalFlowLayout.RIGHT);
        }
        return this;
    }

    public VFlowPane verticalAlignment(Alignment alignment) {
        switch (alignment) {
            case TOP -> layout.setVAlign(VerticalFlowLayout.TOP);
            case CENTER -> layout.setVAlign(VerticalFlowLayout.CENTER);
            case BOTTOM -> layout.setVAlign(VerticalFlowLayout.BOTTOM);
        }
        return this;
    }


    public VFlowPane add(JComponent component) {
        this.component.add(component);
        return this;
    }

    public VFlowPane add(Component component) {
        component.initParent(this);
        return add(component.getComponent());
    }

}
