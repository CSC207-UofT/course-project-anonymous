import Entites.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMeal {
    Meal meal;

    @Before
    public void initializeManager() {
        meal = new Meal("Sushi", 500, 5.0, false);

    }
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
