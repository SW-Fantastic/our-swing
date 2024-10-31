package org.swdc.swing.comp;

import org.swdc.swing.Component;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;

public class TreeView extends Component<JTree,TreeView> {

    private DefaultMutableTreeNode root = new DefaultMutableTreeNode();

    public TreeView() {
        super(new JTree());
        component.setModel(new DefaultTreeModel(root));
    }

    public TreeView add(DefaultMutableTreeNode node) {
        root.add(node);
        return this;
    }

    public TreeView cellRender(TreeCellRenderer renderer) {
        component.setCellRenderer(renderer);
        return this;
    }

}
