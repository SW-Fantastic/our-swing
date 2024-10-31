package org.swdc.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;

public class ReflectionMouseAdapter extends MouseAdapter implements ActionListener {

    private String mouseDownMethod;

    private EventHandler<MouseEvent> mouseDownHandler;

    private String mouseMoveMethod;

    private EventHandler<MouseEvent> mouseMoveHandler;

    private String mouseUpMethod;

    private EventHandler<MouseEvent> mouseUpHandler;

    private String clickMethod;

    private EventHandler<MouseEvent> clickHandler;

    private String actionMethod;

    private EventHandler<ActionEvent> actionHandler;

    private Component component;

    public ReflectionMouseAdapter(Component component) {
        this.component = component;
    }

    public ReflectionMouseAdapter click(String name) {
        this.clickMethod = name;
        return this;
    }

    public ReflectionMouseAdapter click(EventHandler<MouseEvent> handler) {
        this.clickHandler = handler;
        return this;
    }

    public ReflectionMouseAdapter mouseDown(String name) {
        this.mouseDownMethod = name;
        return this;
    }

    public ReflectionMouseAdapter mouseDown(EventHandler<MouseEvent> handler) {
        this.mouseDownHandler = handler;
        return this;
    }

    public ReflectionMouseAdapter mouseUp(String name) {
        this.mouseUpMethod = name;
        return this;
    }

    public ReflectionMouseAdapter mouseUp(EventHandler<MouseEvent> handler) {
        this.mouseUpHandler = handler;
        return this;
    }

    public ReflectionMouseAdapter mouseMove(String name) {
        this.mouseMoveMethod = name;
        return this;
    }

    public ReflectionMouseAdapter mouseMove(EventHandler<MouseEvent> handler) {
        this.mouseMoveHandler = handler;
        return this;
    }

    public ReflectionMouseAdapter action(String actionMethod) {
        this.actionMethod = actionMethod;
        return this;
    }

    public ReflectionMouseAdapter action(EventHandler<ActionEvent> handler) {
        this.actionHandler = handler;
        return this;
    }

    private <E> void doInvokeMethod(String name, E e) {
        if (component == null || component.getController() == null) {
            return;
        }
        Class controllerClass = component.getController().getClass();
        try {
            Method clickHandle = controllerClass.getDeclaredMethod(
                    name, e.getClass()
            );
            clickHandle.invoke(component.getController(),e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (clickHandler != null) {
            clickHandler.handle(e);
            return;
        }
        if (clickMethod == null || clickMethod.isBlank()) {
            return;
        }
        doInvokeMethod(clickMethod,e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (mouseDownHandler != null) {
            mouseDownHandler.handle(e);
            return;
        }
        if (mouseDownMethod == null || mouseDownMethod.isBlank()) {
            return;
        }
        doInvokeMethod(mouseDownMethod,e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (mouseUpHandler != null) {
            mouseUpHandler.handle(e);
            return;
        }
        if ( mouseUpMethod == null || mouseUpMethod.isBlank()) {
            return;
        }
        doInvokeMethod(mouseUpMethod,e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (mouseMoveHandler != null) {
            mouseMoveHandler.handle(e);
            return;
        }
        if ( mouseMoveMethod == null || mouseMoveMethod.isBlank()) {
            return;
        }
        doInvokeMethod(mouseMoveMethod,e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (actionHandler != null){
            actionHandler.handle(e);
            return;
        }
        if ( actionMethod == null || actionMethod.isBlank()) {
            return;
        }
        doInvokeMethod(actionMethod,e);
    }
}
