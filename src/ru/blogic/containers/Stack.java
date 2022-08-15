package ru.blogic.containers;

import ru.blogic.enums.Shape;
import ru.blogic.exceptions.ItemAlreadyPlacedException;
import ru.blogic.exceptions.ItemStoreException;
import ru.blogic.items.Item;
import ru.blogic.writers.SVGWriter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class Stack extends Container {
    private Deque<Item> orderedItemList;

    public Stack(String name, double weight, int size, String color, LinkedList<Item> itemList, double maxWeight) {
        super(name, weight, size, Shape.FLAT, color, itemList, maxWeight);
        this.orderedItemList = itemList;
    }

    public Stack(double weight, int size, LinkedList<Item> itemList) {
        super("Поднос", weight, size, Shape.FLAT, "Red", itemList, 500);
        this.orderedItemList = itemList;
    }

    protected Deque<Item> getOrderedItemList() {
        return this.orderedItemList;
    }


    @Override
    public void putItem(Item item) {
        try{
            if(item.getShape().equals(Shape.ROUND)){
                throw new IllegalArgumentException("Нельзя положить в стопку круглый предмет");
            }else {
                increase(item);
                item.setIsStored(true);
                this.getOrderedItemList().addLast(item);
            }
        } catch(ItemStoreException e){
            e.printStackTrace();
        }
    }

    @Override
    public Item getItem() {
        if (this.getOrderedItemList().size() > 0){
            Item neededItem = this.getOrderedItemList().removeLast();
            decrease(neededItem);
            neededItem.setIsStored(false);
            return neededItem;
        }
        else{
            throw new IllegalArgumentException("Контейнер пуст");
        }

    }

    @Override
    public Item peekItem(String name) {
        return null;
    }

    public Item peekItem() {
        return this.getOrderedItemList().peekLast();
    }

    @Override
    public void draw(int x, int y,SVGWriter writer) {
        int w = getW();
        int h = getH();
        List<Item> items = super.getItemList();
        //writer.writeRect(x, y+h, w, 1, "red", this.getColor().toLowerCase());
        //int currentX = x;
        int currentY = y+h;
        for (Item item: items){
            currentY-=item.getH();
            item.draw((x+w-item.getW()/2), currentY, writer);
        }
    }

    @Override
    public int getW() {
        return getSize()*2;
    }

    @Override
    public int getH() {
        return getSize()*2;
    }
}
