package org.swdc.swing.comp;

import org.swdc.swing.Component;

import javax.swing.*;

public class ComboBox<E> extends Component<JComboBox<E>,ComboBox<E>> {

    public ComboBox() {
        super(new JComboBox<>());
    }

    public ComboBox<E> editable(boolean val) {
        component.setEditable(val);
        return this;
    }

    public ComboBox<E> lightWeightPopup(boolean val) {
        component.setLightWeightPopupEnabled(val);
        return this;
    }

    public ComboBox<E> editor(ComboBoxEditor editor) {
        component.setEditor(editor);
        return this;
    }

    public ComboBox<E> addItem(E e) {
        component.addItem(e);
        return this;
    }

    public ComboBox<E> clearItems() {
        component.removeAllItems();
        return this;
    }


}
