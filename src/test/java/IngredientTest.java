import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void ingredientGetNameReturnsName() {
        String name = "Ingredient name";
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, 15f);
        String actual = ingredient.getName();
        Assert.assertEquals("Values do not match", name, actual);
    }

    @Test
    public void ingredientGetPriceReturnsPrice() {
        float price = 15f;
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Ingredient name", price);
        float actual = ingredient.getPrice();
        Assert.assertEquals("Values do no match", price, actual, 0);
    }

    @Test
    public void ingredientGetTypeReturnsType() {
        IngredientType ingredientType = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(ingredientType, "Ingredient name", 15f);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("Values do not match", ingredientType, actual);
    }
}



