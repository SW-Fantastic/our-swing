package org.swdc.swing.containers;

import org.swdc.swing.Alignment;
import org.swdc.swing.Component;

import javax.swing.*;
import java.awt.*;

public class HFlowPane extends Component<JPanel,HFlowPane> {

    private FlowLayout layout;

    public HFlowPane() {
        super(new JPanel());
        layout = new FlowLayout();
        component.setLayout(layout);
    }

    public HFlowPane gapX(int gap) {
        layout.setHgap(gap);
        return this;
    }

    public HFlowPane gapY(int gap) {
        layout.setVgap(gap);
        return this;
    }

    public HFlowPane alignment(Alignment alignment) {
        switch (alignment) {
            case LEFT -> layout.setAlignment(FlowLayout.LEFT);
            case CENTER -> layout.setAlignment(FlowLayout.CENTER);
            case RIGHT -> layout.setAlignment(FlowLayout.RIGHT);
        }
        return this;
    }

    public HFlowPane alignBaseLine(boolean val) {
        layout.setAlignOnBaseline(val);
        return this;
    }

    public HFlowPane add(JComponent component) {
        this.component.add(component);
        return this;
    }

    public HFlowPane add(Component component) {
        component.initParent(this);
        return add(component.getComponent());
    }

}
