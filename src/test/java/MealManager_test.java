import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class MealManager_test {

        MealsManager mealManager;

        @Before
        public void initializeManager() {
            mealManager = new MealsManager();
        }

        @Test
        public void testMeals() {

            assert(mealManager.checkForMeal("No Meal") == true);

        }


}
