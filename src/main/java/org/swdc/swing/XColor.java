package org.swdc.swing;

import java.awt.*;

public class XColor {

    private int r;

    private int g;

    private int b;

    private int a;


    public XColor(String colorStr) {
        colorStr = colorStr.toLowerCase();
        if (colorStr.startsWith("#")) {
            colorStr = colorStr.substring(1);
            if (colorStr.length() == 3) {
                r = Integer.parseInt(colorStr.substring(0,1).repeat(2),16);
                g = Integer.parseInt(colorStr.substring(1,2).repeat(2),16);
                b = Integer.parseInt(colorStr.substring(2).repeat(2),16);
                a = 255;
            } else if (colorStr.length() == 6) {
                r = Integer.parseInt(colorStr.substring(0, 2), 16);
                g = Integer.parseInt(colorStr.substring(2, 4), 16);
                b = Integer.parseInt(colorStr.substring(4, 6), 16);
                a = 255;
            } else if (colorStr.length() == 8) {
                r = Integer.parseInt(colorStr.substring(0, 2), 16);
                g = Integer.parseInt(colorStr.substring(2, 4), 16);
                b = Integer.parseInt(colorStr.substring(4, 6), 16);
                a = Integer.parseInt(colorStr.substring(6, 8), 16);
            } else {
                throw new RuntimeException("unsupported color string format: " + colorStr);
            }
        } else if (colorStr.startsWith("rgb")) {
            if (colorStr.startsWith("rgb(")) {
                colorStr = colorStr.replace("rgb(", "")
                        .replace(")", "");
                String[] rgb = colorStr.split(",");
                r = Integer.parseInt(rgb[0]);
                g = Integer.parseInt(rgb[1]);
                b = Integer.parseInt(rgb[2]);
                a = 255;
            } else if (colorStr.startsWith("rgba(")) {

                colorStr = colorStr.replace("rgba(","")
                        .replace(")","");
                String[] rgba = colorStr.split(",");
                String a = rgba[3];
                if (a.indexOf('.') > 0) {
                    double alpha = Double.parseDouble(a);
                    int intAlpha = (int)(alpha * 255);
                    a = "" + intAlpha;
                }

                this.r = Integer.parseInt(rgba[0]);
                this.g = Integer.parseInt(rgba[1]);
                this.b = Integer.parseInt(rgba[2]);
                this.a = Integer.parseInt(a);

            } else {
                throw new RuntimeException("unsupported color string format: " + colorStr);
            }
        } else {
            throw new RuntimeException("unsupported color string format: " + colorStr);
        }
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Color asSwing() {
        return new Color(r,g,b,a);
    }

}

