package org.swdc.swing.containers;

import org.swdc.swing.Component;
import org.swdc.swing.Direction;

import javax.swing.*;

public class SplitPane extends Component<JSplitPane,SplitPane> {

    public SplitPane(Direction direction) {
        super(new JSplitPane(direction == Direction.VERTICAL ? SwingConstants.VERTICAL : SwingConstants.HORIZONTAL));
    }

    public SplitPane add(JComponent component) {
        this.component.add(component);
        return this;
    }

    public SplitPane add(Component component) {
        component.initParent(this);
        return add(component.getComponent());
    }

}
