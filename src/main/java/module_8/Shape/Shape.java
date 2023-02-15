package module_8.Shape;

import module_8.enums.Color;
import module_8.enums.Dashes;
import module_8.interfaces.ShapeDrawabl;

public class Shape implements ShapeDrawabl {
    protected double startX;
    protected double startY;
    protected double height;
    protected double width;
    protected Color fillColor;
    protected Color strokePaint;
    protected Dashes dashes;

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public Color getStrokePaint() {
        return this.strokePaint;
    }

    @Override
    public double getStartX() {
        return this.startX;
    }

    @Override
    public double getStartY() {
        return this.startY;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public Dashes getDashes() {
        return this.dashes;
    }

    @Override
    public void draw() {
        System.out.println("Shape");
    }

}
