package ru.blogic.items;

import ru.blogic.enums.Shape;
import ru.blogic.writers.SVGWriter;

public class RubikCube extends Item{
    public RubikCube(double weight, int size, String color) {
        super("Кубик Рубика", weight, size, Shape.SQUARE, color);
    }
    public RubikCube(double weight) {
        super("Кубик Рубика", weight, 1, Shape.SQUARE, "Red");
    }
    public RubikCube() {
        super("Кубик Рубика", 0.5, 1, Shape.SQUARE, "Red");
    }

    @Override
    public void draw(int x, int y,SVGWriter writer) {
        writer.writeRect(x, y, this.getW(),this.getH(),"black", this.getColor().toLowerCase());
    }

    @Override
    public int getW() {
        return this.getSize()*5;
    }

    @Override
    public int getH() {
        return this.getSize()*5;
    }
}
