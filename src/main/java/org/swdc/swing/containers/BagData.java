package org.swdc.swing.containers;

import org.swdc.swing.Alignment;
import org.swdc.swing.Component;
import org.swdc.swing.Direction;

import javax.swing.*;
import java.awt.*;

public class BagData {

    private GridBagConstraints info = new GridBagConstraints();

    private GridBagPane parent;

    public BagData(GridBagPane parent) {
        this.parent = parent;
    }

    public BagData x(int x) {
        info.gridx = x;
        return this;
    }

    public BagData y(int y) {
        info.gridy = y;
        return this;
    }

    public BagData rowSpan(int w) {
        info.gridheight = w;
        return this;
    }

    public BagData insets(int h, int v) {
        info.insets = new Insets(v,h,v,h);
        return this;
    }

    public BagData insets(int val) {
        info.insets = new Insets(val,val,val,val);
        return this;
    }

    public BagData insets(int top, int right, int bottom, int left) {
        info.insets = new Insets(top,left,bottom,right);
        return this;
    }

    public BagData colSpan(int h) {
        info.gridwidth = h;
        return this;
    }

    public BagData scaleX(double x) {
        info.weightx = x;
        return this;
    }

    public BagData scaleY(double y) {
        info.weighty = y;
        return this;
    }

    public BagData fill(Direction direction) {
        switch (direction) {
            case BOTH -> info.fill = GridBagConstraints.BOTH;
            case VERTICAL -> info.fill = GridBagConstraints.VERTICAL;
            case HORIZONTAL -> info.fill = GridBagConstraints.HORIZONTAL;
        }
        return this;
    }

    public BagData align(Alignment alignment) {
        switch (alignment) {
            case LEFT -> info.anchor = GridBagConstraints.WEST;
            case CENTER -> info.anchor = GridBagConstraints.CENTER;
            case RIGHT -> info.anchor = GridBagConstraints.EAST;
            case TOP -> info.anchor = GridBagConstraints.NORTH;
            case BOTTOM -> info.anchor = GridBagConstraints.SOUTH;
        }
        return this;
    }

    public BagData align(Alignment x, Alignment y) {
        switch (x) {
            case LEFT -> {
                switch (y) {
                    case CENTER -> info.anchor = GridBagConstraints.WEST;
                    case TOP -> info.anchor = GridBagConstraints.NORTHWEST;
                    case BOTTOM -> info.anchor = GridBagConstraints.SOUTHWEST;
                }
            }
            case RIGHT -> {
                switch (y) {
                    case CENTER -> info.anchor = GridBagConstraints.EAST;
                    case TOP -> info.anchor = GridBagConstraints.NORTHEAST;
                    case BOTTOM -> info.anchor = GridBagConstraints.SOUTHEAST;
                }
            }
            case CENTER -> {
                switch (y) {
                    case CENTER -> info.anchor = GridBagConstraints.CENTER;
                    case TOP -> info.anchor = GridBagConstraints.NORTH;
                    case BOTTOM -> info.anchor = GridBagConstraints.SOUTH;
                }
            }
        }
        return this;
    }

    public GridBagPane add(JComponent component) {
        parent.getComponent().add(component,info);
        return parent;
    }

    public GridBagPane add(Component component) {
        component.initParent(parent);
        return add(component.getComponent());
    }

}
