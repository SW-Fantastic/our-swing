package org.swdc.swing.comp;

import org.swdc.swing.Component;
import org.swdc.swing.TableAutoResize;
import org.swdc.swing.XColor;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableView extends Component<JTable,TableView> {

    private Map<String,TableColumn> columns = new HashMap<>();

    public TableView() {
        super(new JTable(new DefaultTableModel()));
        DefaultTableModel model = (DefaultTableModel) component.getModel();
        model.addTableModelListener(this::modelChanged);
    }

    private void modelChanged(TableModelEvent event) {
        DefaultTableModel model = (DefaultTableModel) component.getModel();
        TableColumnModel columnModel = component.getColumnModel();
        List<String> notFound = new ArrayList<>(this.columns.keySet());
        for(int i = 0; i < model.getColumnCount(); i ++) {

            String name = model.getColumnName(i);
            TableColumn column = columns.get(name);
            if (column == null) {
                continue;
            }
            notFound.remove(name);
            TableColumn target = columnModel.getColumn(i);

            target.setWidth(column.getWidth());
            target.setMinWidth(column.getMinWidth());
            target.setMaxWidth(column.getMaxWidth());
            target.setPreferredWidth(column.getPreferredWidth());
            target.setCellRenderer(column.getCellRenderer());
            target.setWidth(column.getWidth());
            target.setHeaderRenderer(column.getHeaderRenderer());

        }

        for (String keys : notFound) {
            columns.remove(keys);
        }

    }


    public <T extends DefaultTableModel> TableView model(T model) {

        DefaultTableModel tableModel = (DefaultTableModel)component.getModel();
        tableModel.removeTableModelListener(this::modelChanged);
        model.addTableModelListener(this::modelChanged);
        this.component.setModel(model);

        return this;
    }

    public TableView addColumn(String text, Column column) {

        DefaultTableModel model = (DefaultTableModel) component.getModel();
        model.addColumn(text);
        columns.put(text,column.asColumn());

        return this;

    }

    public TableView autoResize(TableAutoResize resize) {
        switch (resize) {
            case ALL_COLUMN : {
                component.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                break;
            }
            case RESIZE_OFF: {
                component.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                break;
            }
            case LAST_COLUMN:{
                component.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                break;
            }
            case NEXT_COLUMN:{
                component.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
                break;
            }
        }
        return this;
    }

    public TableView enableCellSelection(boolean val) {
        component.setCellSelectionEnabled(val);
        return this;
    }

    public TableView enableColumnSelection(boolean val) {
        component.setColumnSelectionAllowed(val);
        return this;
    }

    public TableView dragEnable(boolean val) {
        component.setDragEnabled(val);
        return this;
    }

    public TableView gridColor(XColor color) {
        component.setGridColor(color.asSwing());
        return this;
    }

    public TableView gridColor(Color color) {
        component.setGridColor(color);
        return this;
    }

    public TableView rowMargin(int val) {
        component.setRowMargin(val);
        return this;
    }

    public TableView rowHeight(int val) {
        component.setRowHeight(val);
        return this;
    }

    public TableView gridVisible(boolean val) {
        component.setShowGrid(val);
        return this;
    }

}
