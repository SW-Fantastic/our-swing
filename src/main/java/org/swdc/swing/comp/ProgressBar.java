package org.swdc.swing.comp;

import org.swdc.swing.Component;

import javax.swing.*;

public class ProgressBar extends Component<JProgressBar,ProgressBar> {

    public ProgressBar() {
        super(new JProgressBar());
    }

    public ProgressBar maxValue(int val) {
        component.setMaximum(val);
        return this;
    }

    public ProgressBar minValue(int val) {
        component.setMinimum(val);
        return this;
    }

    public ProgressBar value(int val) {
        component.setValue(val);
        return this;
    }

}
