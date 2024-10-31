package org.swdc.swing;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.lang.reflect.Method;

public class ReflectionKeyAdapter extends KeyAdapter {

    private String keyDownMethod;

    private EventHandler<KeyEvent> keyDownHandle;

    private String keyUpMethod;

    private EventHandler<KeyEvent> keyUpHandle;

    private String keyTypedMethod;

    private EventHandler<KeyEvent> keyTypedHandle;

    private Component component;

    public ReflectionKeyAdapter(Component component) {
        this.component = component;
    }

    public ReflectionKeyAdapter keyDown(String name) {
        this.keyDownMethod = name;
        return this;
    }

    public ReflectionKeyAdapter keyDown(EventHandler<KeyEvent> handler) {
        this.keyDownHandle = handler;
        return this;
    }

    public ReflectionKeyAdapter keyUp(String name) {
        this.keyUpMethod = name;
        return this;
    }

    public ReflectionKeyAdapter keyUp(EventHandler<KeyEvent> handler) {
        this.keyUpHandle = handler;
        return this;
    }

    public ReflectionKeyAdapter keyTyped(String name) {
        this.keyTypedMethod = name;
        return this;
    }

    public ReflectionKeyAdapter keyTyped(EventHandler<KeyEvent> handler) {
        this.keyTypedHandle = handler;
        return this;
    }

    private void doInvokeMethod(String name, KeyEvent e) {
        if (component.getController() == null) {
            return;
        }
        Object controller = component.getController();
        Class controllerClass = controller.getClass();
        try {
            Method clickHandle = controllerClass.getDeclaredMethod(
                    name, KeyEvent.class
            );
            clickHandle.invoke(controller,e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (keyDownHandle != null) {
            keyDownHandle.handle(e);
            return;
        }
        if (component.getController() == null || keyDownMethod == null || keyDownMethod.isBlank()) {
            return;
        }
        doInvokeMethod(keyDownMethod,e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (keyUpHandle != null) {
            keyUpHandle.handle(e);
            return;
        }
        if (component.getController() == null || keyUpMethod == null || keyUpMethod.isBlank()) {
            return;
        }
        doInvokeMethod(keyUpMethod,e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (keyTypedHandle != null) {
            keyTypedHandle.handle(e);
        }
        if (component.getController() == null || keyTypedMethod == null || keyTypedMethod.isBlank()) {
            return;
        }
        doInvokeMethod(keyTypedMethod,e);
    }
}
