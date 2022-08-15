package ru.blogic.containers;

import ru.blogic.enums.Shape;
import ru.blogic.exceptions.ItemAlreadyPlacedException;
import ru.blogic.exceptions.ItemStoreException;
import ru.blogic.items.Item;
import ru.blogic.items.Itemable;
import ru.blogic.items.RubikCube;

import java.util.List;


public abstract class Container extends Item {
    protected List<Item> itemList;
    private double maxWeight;
    private double itemsWeight;
    private int itemsSize;

    public Container(String name, double weight, int size, Shape shape, String color, List<Item> itemList, double maxWeight) {
        super(name, weight, shape, color);
        this.itemList = itemList;
        this.maxWeight = maxWeight;
        this.setSize(checkListSize(size));
        this.itemsSize = calculateItemsSize(itemList);
        this.itemsWeight = calculateItemsWeight(itemList);
    }
    public Container(String name, double weight, Shape shape, String color, List<Item> itemList, double maxWeight) {
        super(name, weight, shape, color);
        this.itemList = itemList;
        this.maxWeight = maxWeight;
        this.setSize(MAX_CONTAINER_SIZE);
        this.itemsSize = calculateItemsSize(itemList);
        this.itemsWeight = calculateItemsWeight(itemList);
    }

    public void printItems(){
        for(Item item: itemList){
            System.out.println(item);
        }
    }



    public double getMaxWeight() {return this.maxWeight;}

    public double getItemsWeight() {return this.itemsWeight;}

    public int getItemsSize() {return this.itemsSize;}

    public double getTotalWeight() {return this.getItemsWeight() + this.getWeight();}

    protected List<Item> getItemList() {return this.itemList;}

    public int calculateItemsSize(List<Item> itemList) {
        int counter = 0;
        try {
            for(Item item: itemList) counter += item.getSize();
            if(counter > this.getSize()){
                throw new ItemStoreException();
            }
        } catch (ItemStoreException e){
            e.printStackTrace();
        }
        return counter;
    }
    public double calculateItemsWeight(List<Item> itemList) {
        double counter = 0;
        try {
            for(Item item: itemList) {
                if(item instanceof Container){
                    counter += ((Container) item).getTotalWeight();
                }else{
                    counter += item.getWeight();
                }
            };
            if(counter > this.getMaxWeight() - this.getWeight()){
                throw new ItemStoreException();
            }
        } catch (ItemStoreException e){
            e.printStackTrace();
        }
        return counter;
    }

    protected void increase(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        if(item instanceof Container & check(item)){
            this.itemsWeight +=((Container) item).getTotalWeight();
            this.itemsSize += item.getSize();
        } else if(check(item)) {
            this.itemsWeight += item.getWeight();
            this.itemsSize += item.getSize();
        } else{
            throw new ItemStoreException();
        }
    };
    protected void decrease(Item item){
        if(item instanceof Container){
                this.itemsWeight -=((Container) item).getTotalWeight();
        } else {
            this.itemsWeight -= item.getWeight();
        }
        this.itemsSize -= item.getSize();
    };
    protected boolean check(Item item) {
        if(item.getIsStored()){
            throw new ItemAlreadyPlacedException();
        }else{
            if(item instanceof Container){
                return (((Container) item).getTotalWeight()) <= (getMaxWeight()-getTotalWeight())
                        && (item.getSize() <= this.getSize() - this.getItemsSize());

            } else{
                return  ((item.getWeight()) <= getMaxWeight()-getTotalWeight())
                        && (item.getSize() <= this.getSize() - this.getItemsSize());
            }
        }
    }

    public abstract void putItem(Item item) throws ItemStoreException;
    public abstract Item getItem();
    public abstract Item peekItem(String name);

    @Override
    public String toString() {
        return "Container{" +
                "name=" + this.getName() +
                ", itemsWeight=" + itemsWeight +
                ", maxWeight=" + maxWeight +
                ", size=" + this.getSize() +
                ", itemsSize=" + itemsSize +
                ", itemList=" + itemList +
                '}';
    }
}


