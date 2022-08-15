package ru.blogic.containers;

import ru.blogic.enums.Shape;
import ru.blogic.exceptions.ItemAlreadyPlacedException;
import ru.blogic.exceptions.ItemStoreException;
import ru.blogic.items.Item;
import ru.blogic.writers.SVGWriter;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Bag extends Container {
    public Bag(String name, double weight, int size, String color, ArrayList<Item> itemList, double maxWeight) {
        super(name, weight, size, Shape.ROUND, color, itemList, maxWeight);
    }

    public Bag(double weight, int size) {
        super("Мешок", weight, size, Shape.ROUND, "Gray", new ArrayList<Item>(), 500);
    }

    public Bag(double weight) {
        super("Мешок", weight, Shape.ROUND, "Gray", new ArrayList<Item>(), 500);
    }


    @Override
    public void putItem(Item item) throws ItemStoreException {
            increase(item);
            item.setIsStored(true);
            super.getItemList().add(item);

    }

    @Override
    public Item getItem() {
        List<Item> tempItemList = super.getItemList();
        if (tempItemList.size() > 0){
            int num = (int) (Math.random() * ((tempItemList.size()) + 1));
            Item temp = tempItemList.get(num);
            tempItemList.remove(num);
            decrease(temp);
            temp.setIsStored(false);
            return temp;
        }
        else{
            throw new IllegalArgumentException("Контейнер пуст");
        }
    }

    @Override
    public Item peekItem(String name) {
        for (Item item : super.getItemList()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Такого предмета не существует");
    }
    @Override
    public void draw(int x, int y,SVGWriter writer) {
        int w = getW();
        int h = getH();
        int r1 = (int)(w/10);
        int r2 = (int)(h/10);
        writer.writeRoundRect(x,y,w,h,r1,r2,"black", this.getColor().toLowerCase());
        List<Item> items = super.getItemList();
        int currentX = x;
        int currentY = y+h-2;
        int maxRowH = 0;

        for (Item item: items){
            if(currentX + item.getW() > x+w){
               currentY -= maxRowH+1;
               maxRowH = item.getH();
               currentX = x;
               item.draw(currentX, currentY-item.getH(), writer);
            }else{
                item.draw(currentX, currentY-item.getH(), writer);
                currentX  += item.getW();
            }
            if(maxRowH<item.getH()) maxRowH = item.getH();
        }
    }
    @Override
    public int getW() {
        return this.getSize()*2;
    }

    @Override
    public int getH() {

        return this.getSize()*2;
    }

}

