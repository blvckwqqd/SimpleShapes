package ru.blogic.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.blogic.items.Apple;
import ru.blogic.items.Brick;
import ru.blogic.items.RubikCube;


public class TestItems {

    @Test
    public void checkIllegalItemArgument(){
        // Check size limit of Apple item
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Apple(10, 8));
        // Check size limit of Brick item
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Brick(12, 6));
        // Check size limit of RubikCube item
        Assertions.assertThrows(IllegalArgumentException.class, () -> new RubikCube(10, 7, "Black"));
    }

    @Test
    public void checkItemsEquality(){
        //Check equality of Apples
        Assertions.assertEquals(new Apple(10.0, 2), new Apple(10, 2));
        //Check equality of Bricks
        Assertions.assertEquals(new Brick(12, 5), new Brick(12, 5));
        //Check equality of RubikCube's
        Assertions.assertEquals(new RubikCube(10, 1, "Black"), new RubikCube(10, 1, "Black"));

        //Check not equality of Apples
        Assertions.assertNotEquals(new Apple(10.000000001, 2), new Apple(10, 2));
    }

    @Test
    public void checkItemsToString(){
        Apple firstApple = new Apple(10.0, 2);
        Apple secondApple = new Apple(10, 2);
        //Checking Apple.toString() method
        Assertions.assertEquals(firstApple.toString(), secondApple.toString());

        Brick firstBrick = new Brick(10, 4);
        Brick secondBrick = new Brick(10.0, 4);
        //Checking Brick.toString() method
        Assertions.assertEquals(firstBrick.toString(), secondBrick.toString());

        RubikCube firstCube = new RubikCube();
        RubikCube secondCube = new RubikCube();
        //Checking RubikCube.toString() method
        Assertions.assertEquals(firstCube.toString(), secondCube.toString());

    }
}
