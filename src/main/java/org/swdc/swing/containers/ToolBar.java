package org.swdc.swing.containers;

import org.swdc.swing.Component;
import org.swdc.swing.Direction;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends Component<JToolBar,ToolBar> {

    public ToolBar(Direction direction) {
        super(new JToolBar(direction == Direction.VERTICAL ? SwingConstants.VERTICAL : SwingConstants.HORIZONTAL));
    }

    public ToolBar add(JComponent component) {
        this.component.add(component);
        return this;
    }

    public ToolBar add(Component component) {
        component.initParent(this);
        return add(component.getComponent());
    }

    public ToolBar margin(int margin) {
        Insets insets = new Insets(margin,margin,margin,margin);
        component.setMargin(insets);
        return this;
    }

    public ToolBar marginX(int x) {
        Insets margin = component.getMargin();
        margin.left = x;
        margin.right = x;
        component.setMargin(margin);
        return this;
    }

    public ToolBar marginY(int y) {
        Insets margin = component.getMargin();
        margin.top = y;
        margin.bottom = y;
        component.setMargin(margin);
        return this;
    }

    public ToolBar addSeparator(){
        component.addSeparator();
        return this;
    }

    public ToolBar addSpacing(int size) {
        JLabel label = new JLabel();
        Dimension dimension = new Dimension(10,size);
        if (component.getOrientation() == SwingConstants.VERTICAL) {
            dimension = new Dimension(10,size);
        } else {
            dimension = new Dimension(size,10);
        }
        label.setSize(dimension);
        label.setMinimumSize(dimension);
        label.setPreferredSize(dimension);
        add(label);
        return this;
    }

}
