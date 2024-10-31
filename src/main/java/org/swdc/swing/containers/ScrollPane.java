package org.swdc.swing.containers;

import org.swdc.swing.Component;
import org.swdc.swing.comp.TableView;

import javax.swing.*;

public class ScrollPane extends Component<JScrollPane,ScrollPane> {

    public ScrollPane() {
        super(new JScrollPane());
    }

    public ScrollPane content(JComponent component) {
        this.component.setViewportView(component);
        return this;
    }

    public ScrollPane content(Component view) {
        view.initParent(this);
        return content(view.getComponent());
    }

}
