package ru.blogic.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.blogic.containers.Bag;
import ru.blogic.containers.Stack;
import ru.blogic.exceptions.ItemAlreadyPlacedException;
import ru.blogic.exceptions.ItemStoreException;
import ru.blogic.items.Apple;
import ru.blogic.items.Brick;
import ru.blogic.items.Item;
import ru.blogic.items.RubikCube;


import java.util.ArrayList;
import java.util.LinkedList;

public class TestContainers {

    @Test
    public void checkBagContainer() throws ItemStoreException {
        Bag bagFirst = new Bag(0.1, 30);
        Bag bagSecond = new Bag(0.1);
        Bag bagThird = new Bag("Мешок", 0.1, 50, "Gray", new ArrayList<Item>(), 500);

        Apple firstApple = new Apple(5, 5);
        Apple secondApple = new Apple(0.5, 3);
        Apple thirdApple = new Apple(0.1, 1);

        Brick firstBrick = new Brick(3.1, 3);
        Brick secondBrick = new Brick(1.1, 1);
        Brick thirdBrick = new Brick(0.1, 1);

        RubikCube firstCube = new RubikCube(150);
        RubikCube secondCube = new RubikCube(180, 5, "White");
        RubikCube thirdCube = new RubikCube(180, 5, "White");

        bagSecond.putItem(firstApple);
        String str = new String("");

        Assertions.assertThrows(ItemStoreException.class, ()->{
            bagSecond.putItem(bagFirst);
            bagSecond.putItem(bagThird);
        });
        Assertions.assertThrows(ItemAlreadyPlacedException.class, ()->{
            bagSecond.putItem(firstApple);

        });
    }
    @Test
    public void checkStackContainer() throws ItemStoreException {
        Stack stackFirst = new Stack(0.1, 30, new LinkedList<Item>());
        Stack stackSecond = new Stack(0.1, 50, new LinkedList<Item>());
        Stack stackThird = new Stack("Мешок", 0.1, 50, "Gray", new LinkedList<Item>(), 500);

        Apple firstApple = new Apple(5, 5);
        Apple secondApple = new Apple(0.5, 3);
        Apple thirdApple = new Apple(0.1, 1);
        Apple fourthApple = new Apple(1.2, 5);

        Brick firstBrick = new Brick(3.1, 3);
        Brick secondBrick = new Brick(1.1, 1);
        Brick thirdBrick = new Brick(0.1, 1);

        RubikCube firstCube = new RubikCube(150);
        RubikCube secondCube = new RubikCube(180, 5, "White");
        RubikCube thirdCube = new RubikCube(180, 5, "White");

        stackThird.putItem(firstBrick);
        stackThird.putItem(secondBrick);

        stackSecond.putItem(firstCube);

        Assertions.assertEquals(stackThird.getTotalWeight(), 4.3, 0.00001);

        Assertions.assertThrows(ItemAlreadyPlacedException.class, ()->{
            stackSecond.putItem(firstCube);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()-> stackSecond.putItem(firstApple));

    }
    @Test
    public void checkBoxContainer() throws ItemStoreException {
        Bag bagFirst = new Bag(0.1, 30);
        Bag bagSecond = new Bag(0.1, 50);
        Bag bagThird = new Bag("Мешок", 0.1, 50, "Red", new ArrayList<Item>(), 500);

        Apple firstApple = new Apple(5, 5);
        Apple secondApple = new Apple(0.5, 3);
        Apple thirdApple = new Apple(0.1, 1);
        Apple fourthApple = new Apple(1.2, 5);

        Brick firstBrick = new Brick(3.1, 3);
        Brick secondBrick = new Brick(1.1, 1);
        Brick thirdBrick = new Brick(0.1, 1);

        RubikCube firstCube = new RubikCube(150);
        RubikCube secondCube = new RubikCube(180, 5, "White");
        RubikCube thirdCube = new RubikCube(180, 5, "White");


        bagThird.putItem(firstBrick);
        bagThird.putItem(secondBrick);

        bagSecond.putItem(firstCube);

        Assertions.assertEquals(bagThird.getTotalWeight(), 4.3, 0.00001);
        Assertions.assertThrows(ItemAlreadyPlacedException.class, ()->{
            bagSecond.putItem(firstCube);
        });

    }
}
