package org.swdc.swing.comp;

import org.swdc.swing.Component;
import org.swdc.swing.EventHandler;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.lang.reflect.Method;

public class ListView<E> extends Component<JList<E>,ListView<E>> {

    public static class ReflectionSelectionAdapter implements ListSelectionListener {

        private String selectionMethod;

        private EventHandler<ListSelectionEvent> handler;

        private Component component;

        public ReflectionSelectionAdapter(Component component) {
            this.component = component;
        }

        public ReflectionSelectionAdapter selection(String method) {
            this.selectionMethod = method;
            return this;
        }

        public ReflectionSelectionAdapter selection(EventHandler<ListSelectionEvent> handler) {
            this.handler = handler;
            return this;
        }

        private void doInvokeMethod(String name, ListSelectionEvent e) {
            if (component.getController() == null) {
                return;
            }
            Class controllerClass = component.getController().getClass();
            try {
                Method clickHandle = controllerClass.getDeclaredMethod(
                        name, ListSelectionEvent.class
                );
                clickHandle.invoke(component.getController(),e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (handler != null) {
                handler.handle(e);
                return;
            }
            if (component.getController() == null || selectionMethod == null || selectionMethod.isBlank()) {
                return;
            }
            doInvokeMethod(selectionMethod,e);
        }

    }

    private DefaultListModel<E> model;

    private ReflectionSelectionAdapter selectionAdapter;

    public ListView() {
        super(new JList<>());
        model = new DefaultListModel<>();
        component.setModel(model);
        selectionAdapter = new ReflectionSelectionAdapter(this);
        component.addListSelectionListener(selectionAdapter);
    }

    public ListView<E> add(E elem) {
        model.addElement(elem);
        return this;
    }

    public ListView<E> cellFactory(ListCellRenderer<E> render) {
        component.setCellRenderer(render);
        return this;
    }

    public ListView<E> selectionChange(String selectionMethod) {
        selectionAdapter.selection(selectionMethod);
        return this;
    }

    public ListView<E> selectionChange(EventHandler<ListSelectionEvent> handler) {
        selectionAdapter.selection(handler);
        return this;
    }

}
