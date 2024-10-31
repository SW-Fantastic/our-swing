package org.swdc.swing;

import org.swdc.ours.common.annotations.Annotations;
import org.swdc.swing.comp.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Component<T extends JComponent, S extends Component> {

    protected T component;

    private ReflectionMouseAdapter mouseEvents = new ReflectionMouseAdapter(this);

    private ReflectionKeyAdapter keyAdapter = new ReflectionKeyAdapter(this);

    private Object controller;

    private Component parent;

    private String id;

    private List<Component> children = new ArrayList<>();

    public Component(T component) {
        this.component = component;
        this.component.addMouseListener(mouseEvents);
        this.component.addKeyListener(keyAdapter);
    }

    public S size(int width, int height) {
        this.component.setSize(width,height);
        this.component.setPreferredSize(new Dimension(width,height));
        return (S)this;
    }

    public S bounds(int x, int y, int width, int height) {
        component.setBounds(x,y,width,height);
        return (S)this;
    }

    public S width(int width) {
        this.component.setSize(width,component.getWidth());
        this.component.setPreferredSize(new Dimension(width,component.getPreferredSize().height));
        return (S)this;
    }

    public S maxWidth(int maxWidth) {
        this.component.setMaximumSize(new Dimension(maxWidth, component.getMaximumSize().height));
        return (S)this;
    }

    public S maxHeight(int maxHeight) {
        this.component.setMaximumSize(new Dimension(component.getMaximumSize().width, maxHeight));
        return (S)this;
    }

    public S minWidth(int minWidth) {
        this.component.setMinimumSize(new Dimension(minWidth, component.getMinimumSize().height));
        return (S)this;
    }

    public S minHeight(int minHeight) {
        this.component.setMinimumSize(new Dimension(component.getMinimumSize().width, minHeight));
        return (S)this;
    }

    public S height(int height) {
        this.component.setSize(component.getWidth(),height);
        this.component.setPreferredSize(new Dimension(component.getPreferredSize().width, height));
        return (S)this;
    }

    public S tooltip(String text) {
        component.setToolTipText(text);
        return (S)this;
    }

    public S cursor(Cursor cursor) {
        component.setCursor(cursor);
        return (S)this;
    }

    public S contextMenu(Menu menu) {
        component.setComponentPopupMenu(menu.getComponent());
        return (S)this;
    }

    public S opaque(boolean v) {
        component.setOpaque(v);
        return (S)this;
    }

    public S font(Font font) {
        this.component.setFont(font);
        return (S)this;
    }

    public S color(XColor color) {
        this.component.setForeground(color.asSwing());
        return (S)this;
    }

    public S color(Color color) {
        this.component.setForeground(color);
        return (S)this;
    }

    public S backgroundColor(XColor color) {
        this.component.setBackground(color.asSwing());
        return (S)this;
    }

    public S backgroundColor(Color color) {
        this.component.setBackground(color);
        return (S)this;
    }

    public S mouseDown(String methodName) {
        this.mouseEvents.mouseDown(methodName);
        return (S)this;
    }

    public S mouseDown(EventHandler<MouseEvent> handler) {
        this.mouseEvents.mouseDown(handler);
        return (S)this;
    }

    public S mouseUp(String methodName) {
        this.mouseEvents.mouseUp(methodName);
        return (S)this;
    }

    public S mouseUp(EventHandler<MouseEvent> handler) {
        this.mouseEvents.mouseUp(handler);
        return (S)this;
    }

    public S mouseMove(String methodName) {
        this.mouseEvents.mouseMove(methodName);
        return (S)this;
    }

    public S mouseMove(EventHandler<MouseEvent> handler) {
        this.mouseEvents.mouseMove(handler);
        return (S)this;
    }

    public S mouseClick(String methodName) {
        this.mouseEvents.click(methodName);
        return (S)this;
    }

    public S action(String methodName) {
        this.mouseEvents.action(methodName);
        return (S)this;
    }

    public S action(EventHandler<ActionEvent> handler) {
        this.mouseEvents.action(handler);
        return (S)this;
    }

    public S mouseClick(EventHandler<MouseEvent> handler) {
        this.mouseEvents.click(handler);
        return (S)this;
    }

    public S keyDown(EventHandler<KeyEvent> handler) {
        this.keyAdapter.keyDown(handler);
        return (S)this;
    }

    public S keyDown(String methodName) {
        this.keyAdapter.keyDown(methodName);
        return (S)this;
    }

    public S keyUp(String methodName) {
        this.keyAdapter.keyUp(methodName);
        return (S)this;
    }

    public S keyUp(EventHandler<KeyEvent> handler) {
        this.keyAdapter.keyUp(handler);
        return (S)this;
    }

    public S keyTyped(String methodName) {
        this.keyAdapter.keyTyped(methodName);
        return (S)this;
    }

    public S keyTyped(EventHandler<KeyEvent> handler) {
        this.keyAdapter.keyTyped(handler);
        return (S)this;
    }

    public S disabled(boolean disable) {
        component.setEnabled(!disable);
        for (Component it : children) {
            it.disabled(disable);
        }
        return (S)this;
    }

    public S controller(Object controller) {

        this.controller = controller;

        List<Field> fields = Annotations.getAnnotationField(
                controller.getClass(),
                SwingView.class
        );

        for (Field field: fields) {
            // do inject views.
            try {

                SwingView view = field.getAnnotation(SwingView.class);
                Component target = doFind(view.value(),this);

                field.setAccessible(true);
                field.set(controller,target == null ? null : target.getComponent());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (S)this;
    }

    public S id(String id) {

        this.id = id;
        return (S)this;

    }

    public Object getController() {
        if (controller == null && parent != null) {
            return parent.getController();
        }
        return controller;
    }

    public <S> S initParent(Component parent) {
        if (this.parent != null) {
            throw new RuntimeException("already has a parent.");
        }
        this.parent = parent;
        this.parent.children.add(this);
        return (S)this;
    }

    <T extends Component> T doFind(String id, Component from) {
        if (id.equals(this.getId())) {
            return (T)this;
        }
        for (Component child: children) {
            if (child == from) {
                continue;
            }
            if (child.getId() != null && id.equals(child.getId())) {
                return (T)child;
            } else {
                T rst = (T)child.doFind(id,from);
                if (rst != null) {
                    return rst;
                }
            }
        }
        return null;
    }

    public <T extends Component> T findById(String id) {
        T result = doFind(id,this);
        if (result != null) {
            return result;
        }
        Component parent = this.parent;
        while (parent != null) {
            result = (T) parent.doFind(id,this);
            if (result != null) {
                return result;
            } else {
                parent = parent.parent;
            }
        }
        return null;
    }

    public T getComponent() {
        return component;
    }

    public String getId() {
        return id;
    }

    protected ReflectionMouseAdapter mouseAdapter() {
        return mouseEvents;
    }
}
