package ru.blogic.items;

import ru.blogic.enums.Shape;
import ru.blogic.writers.SVGWriter;

public class Apple extends Item{
    public Apple(double weight, int size, String color) {
        super("Яблоко", weight, size, Shape.ROUND, color);
    }
    public Apple(double weight, int size) {
        super("Яблоко", weight, size, Shape.ROUND, "Green");
    }
    public Apple(double weight) {
        super("Яблоко", weight, 2, Shape.ROUND, "Green");
    }

    @Override
    public void draw(int x, int y, SVGWriter writer) {
        x+=this.getW()/2;
        y+=this.getH()/2;
        writer.writeEllipse(x, y, this.getW()/2, this.getH()/2,"black", this.getColor().toLowerCase());
        //writer.writeText(x, y, this.getName());
    }

    @Override
    public int getW() { return this.getSize()*2; }

    @Override
    public int getH() {
        return this.getSize()*2;
    }
}
