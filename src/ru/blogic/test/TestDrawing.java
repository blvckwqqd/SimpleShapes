package ru.blogic.test;

import org.junit.jupiter.api.Test;
import ru.blogic.containers.Bag;
import ru.blogic.containers.Box;
import ru.blogic.containers.Stack;
import ru.blogic.exceptions.ItemStoreException;
import ru.blogic.items.Apple;
import ru.blogic.items.Brick;
import ru.blogic.items.Item;
import ru.blogic.items.RubikCube;
import ru.blogic.writers.SVGWriter;

import java.util.*;

public class TestDrawing {
    @Test
    public void drawBag() {
        SVGWriter svg = new SVGWriter("Bag.svg");
        Bag bag = new Bag(10, 50);
        Stack stack = new Stack(10, 20, new LinkedList<Item>());
        {
            Apple apple = new Apple(2, 3);
            Brick brick = new Brick(5, 5);
            Brick brick1 = new Brick(2, 5);
            Brick brick2 = new Brick(2, 5);
            Brick brick3 = new Brick(2, 5);
            Brick brick4 = new Brick(2, 5);
            Bag bag1 = new Bag(10, 20);
            try {
                bag.putItem(apple);
                bag.putItem(brick);
                bag.putItem(brick1);
                bag.putItem(brick2);
                bag.putItem(brick3);
                bag.putItem(brick4);
                for (int i = 0; i < 20; i++) {
                    bag1.putItem(new RubikCube());
                }
                for (int i = 0; i < 5; i++) {
                    stack.putItem(new Brick(5,(int)(Math.random()*5+1)));
                }
                bag.putItem(stack);
                //bag.putItem(bag1);
            } catch (ItemStoreException e) {
                e.printStackTrace();
            }
        }
        svg.writeHeader(500, 500);
        bag.draw(200, 200, svg);
        svg.writeFooter();

    }

    @Test
    public void drawBox() {
        SVGWriter svg = new SVGWriter("Box.svg");
        Box box = new Box(10, 50);
        {
            Apple apple = new Apple(2, 5);
            Brick brick = new Brick(5, 2);
            Brick brick1 = new Brick(2, 2);
            Brick brick2 = new Brick(2, 3);
            Brick brick3 = new Brick(2, 4);
            Brick brick4 = new Brick(2, 5);
            Bag bag1 = new Bag(10, 20);
            RubikCube rc1 = new RubikCube();
            RubikCube rc2 = new RubikCube();
            RubikCube rc3 = new RubikCube();
            RubikCube rc4 = new RubikCube();
            RubikCube rc5 = new RubikCube();
            RubikCube rc6 = new RubikCube();
            try {
                box.putItem(apple);
                box.putItem(brick);
                box.putItem(brick1);
                box.putItem(brick2);
                box.putItem(brick3);
                box.putItem(brick4);
                bag1.putItem(rc1);
                bag1.putItem(rc2);
                bag1.putItem(rc3);
                bag1.putItem(rc4);
                bag1.putItem(rc5);
                box.putItem(bag1);
            } catch (ItemStoreException e) {
                e.printStackTrace();
            }
        }
        svg.writeHeader(500, 500);
        box.draw(200, 200, svg);
        svg.writeFooter();
    }

    @Test
    public void drawStack() {
        SVGWriter svg = new SVGWriter("Stack.svg");
        Stack stack = new Stack(10, 50, new LinkedList<Item>());
        {
            Box box = new Box(5,10);
            Brick brick = new Brick(5, 2);
            Brick brick1 = new Brick(2, 2);
            Brick brick2 = new Brick(2, 3);
            Brick brick3 = new Brick(2, 4);
            Brick brick4 = new Brick(2, 5);
            stack.putItem(brick4);
            stack.putItem(brick3);
            stack.putItem(brick2);
            stack.putItem(box);
            stack.putItem(brick1);
            stack.putItem(brick);
            svg.writeHeader(400, 400);
            stack.draw(200, 200, svg);
            svg.writeFooter();
        }
    }
}
