package org.swdc.swing.containers;

import org.swdc.swing.Component;

import javax.swing.*;
import java.awt.*;

public class GridBagPane extends Component<JPanel,GridBagPane> {

    private GridBagLayout gridBagLayout;

    public GridBagPane() {
        super(new JPanel());
        this.gridBagLayout = new GridBagLayout();
        component.setLayout(gridBagLayout);
    }

    public BagData cell() {
        return new BagData(this);
    }

}
