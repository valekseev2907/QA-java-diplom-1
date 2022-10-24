import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.EnumSet;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    IngredientType ingredientType;
    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters (name = "{index}: doesIngredientTypeContains({0})")
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void ingredientTypeContainsCorrectIngredients() {
        Assert.assertTrue(EnumSet.allOf(IngredientType.class).contains(ingredientType));
    }
}
