package ru.blogic.test;

import ru.blogic.containers.Bag;
import ru.blogic.containers.Stack;
import ru.blogic.exceptions.ItemStoreException;
import ru.blogic.items.Apple;

import ru.blogic.items.Brick;
import ru.blogic.items.Item;
import ru.blogic.items.RubikCube;
import ru.blogic.writers.SVGWriter;

import java.io.OutputStream;
import java.nio.file.Files;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {

        Bag bag = new Bag(10,50);
        Stack stack = new Stack(10,50, new LinkedList<Item>());

        Apple apple = new Apple(2,5);
        Brick brick = new Brick(5,2);
        Brick brick1 = new Brick(2,2);
        Brick brick2 = new Brick(2,3);
        Brick brick3 = new Brick(2,4);
        Brick brick4 = new Brick(2,5);
        Bag bag1 = new Bag(10,20);
        RubikCube rc1 = new RubikCube();
        RubikCube rc2 = new RubikCube();
        RubikCube rc3 = new RubikCube();
        RubikCube rc4 = new RubikCube();
        RubikCube rc5 = new RubikCube();
        RubikCube rc6 = new RubikCube();
        try {
            bag.putItem(apple);
            bag.putItem(brick);
            bag.putItem(brick1);
            bag.putItem(brick2);
            bag.putItem(brick3);
            bag.putItem(brick4);
            bag1.putItem(rc1);
            bag1.putItem(rc2);
            bag1.putItem(rc3);
            bag1.putItem(rc4);
            bag1.putItem(rc5);
            bag.putItem(bag1);
        } catch (ItemStoreException e){
            e.printStackTrace();
        }


        SVGWriter svg = new SVGWriter("Drawers.svg");
        svg.writeHeader(500,500);
        bag.draw(200,200,svg);
        svg.writeFooter();


    }
}
