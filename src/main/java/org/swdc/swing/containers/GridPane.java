package org.swdc.swing.containers;

import org.swdc.swing.Component;

import javax.swing.*;
import java.awt.*;

public class GridPane extends Component<JPanel,GridPane> {


    private GridLayout gridLayout;

    public GridPane() {
        super(new JPanel());
        gridLayout = new GridLayout();
        component.setLayout(gridLayout);
    }

    public GridPane columns(int cols) {
        gridLayout.setColumns(cols);
        return this;
    }

    public GridPane rows(int rows) {
        gridLayout.setRows(rows);
        return this;
    }

    public GridPane gapX(int gap) {
        gridLayout.setHgap(gap);
        return this;
    }

    public GridPane gapY(int gap) {
        gridLayout.setVgap(gap);
        return this;
    }

    public GridPane add(JComponent component) {
        this.component.add(component);
        return this;
    }

    public GridPane add(Component component) {
        component.initParent(this);
        return add(component.getComponent());
    }

}
