package ru.blogic.items;

import ru.blogic.enums.Shape;
import ru.blogic.writers.SVGWriter;

public class Brick extends Item{
    public Brick(double weight, int size, String color) {
        super("Кирпич", weight, size, Shape.FLAT, color);
    }
    public Brick(double weight, int size) {
        super("Кирпич", weight, size, Shape.FLAT, "Brown");
    }
    public Brick(double weight) {
        super("Кирпич", weight, 2, Shape.FLAT, "Brown");
    }

    @Override
    public void draw(int x, int y,SVGWriter writer) {
        writer.writeRect(x, y, this.getW(), this.getH(),"black", this.getColor().toLowerCase());
    }

    @Override
    public int getW() {
        return this.getSize()*4;
    }

    @Override
    public int getH() {
        return this.getSize()*2;
    }
}
