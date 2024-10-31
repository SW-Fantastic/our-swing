package org.swdc.swing.comp;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Column {

    private TableColumn column;

    public Column() {
        column = new TableColumn();
    }

    public Column modelIndex(int index){
        column.setModelIndex(index);
        return this;
    }

    public Column cellRender(TableCellRenderer renderer) {
        column.setCellRenderer(renderer);
        return this;
    }

    public Column headerLabel(String text) {
        column.setHeaderValue(text);
        return this;
    }

    public Column headerRender(TableCellRenderer renderer) {
        column.setHeaderRenderer(renderer);
        return this;
    }

    public Column resizable(boolean val) {
        column.setResizable(val);
        return this;
    }

    public Column width(int width) {
        column.setWidth(width);
        column.setPreferredWidth(width);
        return this;
    }

    public Column maxWidth(int width) {
        column.setMaxWidth(width);
        return this;
    }

    public Column minWidth(int width) {
        column.setMinWidth(width);
        return this;
    }

    public TableColumn asColumn() {
        return column;
    }

}
