import Entites.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMeal {
    Meal meal;

    /**
     * initializes a new meal object for the test environment
     */
    @Before
    public void initializeManager() {
        meal = new Meal("Sushi", 500, 5.0, false);

    }

    /**
     * Tests the getPrice, getCalories, getName, and isVegitarian functions of the meal class, assert if
     * it matches the created test meal
     */
    @Test
    public void TestGetPrice(){
        assertEquals(5.0, meal.getPrice(), 0.1);
    }

    @Test
    public void TestGetCalories(){
        assertEquals(500, meal.getCalories(), 0.1);
    }
    @Test
    public void TestGetName(){
        assertEquals("Sushi", meal.getName());
    }
    @Test
    public void TestIsVegitarian(){
        assertEquals(false, meal.isVegitarian());
    }
}
