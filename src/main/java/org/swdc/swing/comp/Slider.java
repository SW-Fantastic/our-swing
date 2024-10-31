package org.swdc.swing.comp;

import org.swdc.swing.Component;
import org.swdc.swing.EventHandler;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.lang.reflect.Method;

public class Slider extends Component<JSlider,Slider> {

    public static class ReflectionChangedAdapter implements ChangeListener {

        public String changeMethod;

        private EventHandler<ChangeEvent> handler;

        private Component component;

        public ReflectionChangedAdapter(Component component) {
            this.component = component;
        }

        public ReflectionChangedAdapter changed(String change) {
            this.changeMethod = change;
            return this;
        }

        public ReflectionChangedAdapter changed(EventHandler<ChangeEvent> handler) {
            this.handler = handler;
            return this;
        }

        private void doInvokeMethod(String name, ChangeEvent e) {
            if (component.getController() == null) {
                return;
            }
            Class controllerClass = component.getController().getClass();
            try {
                Method clickHandle = controllerClass.getDeclaredMethod(
                        name, ChangeEvent.class
                );
                clickHandle.invoke(component.getController(),e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            if (handler != null) {
                handler.handle(e);
                return;
            }
            if (changeMethod == null || changeMethod.isBlank() || component.getController() == null) {
                return;
            }
            doInvokeMethod(changeMethod,e);
        }

    }

    private ReflectionChangedAdapter changedAdapter;

    public Slider() {
        super(new JSlider());
        changedAdapter = new ReflectionChangedAdapter(this);
        component.addChangeListener(changedAdapter);
    }

    public Slider printLabel(boolean val) {
        component.setPaintLabels(val);
        return this;
    }

    public Slider majorTickSpacing(int val) {
        component.setMajorTickSpacing(val);
        return this;
    }

    public Slider minorTickSpacing(int val) {
        component.setMinorTickSpacing(val);
        return this;
    }

    public Slider printTick(boolean val) {
        component.setPaintTicks(val);
        return this;
    }

    public Slider max(int max) {
        component.setMaximum(max);
        return this;
    }

    public Slider min(int min) {
        component.setMinimum(min);
        return this;
    }

    public Slider snapToTicks(boolean val) {
        component.setSnapToTicks(val);
        return this;
    }

    public Slider val(int val) {
        component.setValue(val);
        return this;
    }

    public Slider changed(EventHandler<ChangeEvent> handler) {
        changedAdapter.changed(handler);
        return this;
    }

    public Slider changed(String methodName) {
        changedAdapter.changed(methodName);
        return this;
    }

}
