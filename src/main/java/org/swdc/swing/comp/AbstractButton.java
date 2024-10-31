package org.swdc.swing.comp;

import org.swdc.swing.Component;

import javax.swing.*;

public class AbstractButton<T extends javax.swing.AbstractButton, S extends AbstractButton> extends Component<T,S> {
    public AbstractButton(T component) {
        super(component);
        component.addActionListener(mouseAdapter());
    }

    public S text(String text) {
        component.setText(text);
        return (S)this;
    }


    public S image(ImageIcon image) {
        component.setIcon(image);
        return (S)this;
    }

    public S pressedImage(ImageIcon image) {
        component.setPressedIcon(image);
        return (S)this;
    }

    public S selectedImage(ImageIcon image) {
        component.setSelectedIcon(image);
        return (S)this;
    }

    public S rollOverImage(ImageIcon image) {
        component.setRolloverIcon(image);
        return (S)this;
    }

    public S rollOverSelectImage(ImageIcon image) {
        component.setRolloverSelectedIcon(image);
        return (S)this;
    }

    public S disableImage(ImageIcon image) {
        component.setDisabledIcon(image);
        return (S)this;
    }

    public S iconTextGap(int gap) {
        component.setIconTextGap(gap);
        return (S)this;
    }

}
