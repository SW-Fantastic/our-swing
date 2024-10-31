package org.swdc.swing.comp;

import org.swdc.swing.Component;
import org.swdc.swing.TableAutoResize;
import org.swdc.swing.XColor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableView extends Component<JTable,TableView> {

    public TableView() {
        super(new JTable(new DefaultTableModel()));
    }

    public TableView addColumn(Column column) {
        component.addColumn(column.asColumn());
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
