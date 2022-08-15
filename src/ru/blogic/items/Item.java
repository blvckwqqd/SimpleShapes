package ru.blogic.items;

import ru.blogic.enums.Shape;
import ru.blogic.writers.SVGWriter;

import java.util.Objects;

public abstract class Item implements Itemable {
    private final String name;
    private final double weight;
    private final Shape shape;
    private final String color;

    private int size;
    private boolean isStored;


    protected Item(String name, double weight, int size, Shape shape, String color) {
        this.name = checkString(name);
        this.weight = weight;
        this.size = checkSize(size);
        this.shape = shape;
        this.color = checkString(color);
        this.isStored = false;
    }
    protected Item(String name, double weight, Shape shape, String color) {
        this.name = checkString(name);
        this.weight = weight;
        this.shape = shape;
        this.color = checkString(color);
        this.isStored = false;
    }
    protected void setSize(int size){this.size = size;} // check size

    public void setIsStored(boolean flag){this.isStored = flag;}

    public String getName() { return name; }
    public double getWeight() { return weight; }
    public String getColor() { return color; }
    public int getSize() { return size; }
    public Shape getShape() {return shape;}
    public boolean getIsStored(){return isStored;}

    public abstract void draw(int x, int y,SVGWriter writer);
    public abstract int getW();
    public abstract int getH();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.weight, weight) == 0
                && size == item.size
                && Objects.equals(name, item.name)
                && shape == item.shape
                && Objects.equals(color, item.color

        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, size, shape, color);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", size=" + size +
                ", shape=" + shape +
                ", color='" + color + '\'' +
                '}';
    }
}
