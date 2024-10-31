package org.swdc.swing.comp;

import org.swdc.swing.Component;
import org.swdc.swing.XColor;

import javax.swing.text.JTextComponent;

public class AbstractText<T extends JTextComponent,S extends AbstractText> extends Component<T,S> {

    public AbstractText(T component) {
        super(component);
    }

    public S text(String text) {
        component.setText(text);
        return (S)this;
    }

    public S selectedTextColor(XColor color) {
        component.setSelectedTextColor(color.asSwing());
        return (S)this;
    }

    public S selectedBackgroundColor(XColor color) {
        component.setSelectionColor(color.asSwing());
        return (S)this;
    }

    public S disabledTextColor(XColor color) {
        component.setDisabledTextColor(color.asSwing());
        return (S)this;
    }

    public S caretColor(XColor color) {
        component.setCaretColor(color.asSwing());
        return (S)this;
    }

}
