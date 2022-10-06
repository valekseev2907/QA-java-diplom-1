import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void burgerAddIngredientAddsIngredient() {
        Ingredient expected = new Ingredient(IngredientType.SAUCE, "Sauce name", 40f);
        burger.addIngredient(expected);
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("Values do not match", expected, actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void burgerRemoveIngredientRemovesIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Filling name", 35f);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("Values or exceptions types do not match", IndexOutOfBoundsException.class, actual);
    }

    @Test
    public void burgerMoveIngredientMovesIngredient() {
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "Sauce name", 50f);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "Filing name", 75f);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0,1);
        Ingredient actual = burger.ingredients.get(1);
        Assert.assertEquals("Values do not match", firstIngredient, actual);
    }
    @Test
    public void burgerGetPriseReturnsCorrectPrice() {
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "Sauce name", 50f);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "Sauce name", 25f);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(bun.getPrice()).thenReturn(25f);
        float actual = burger.getPrice();
        float expected = 125f;
        Assert.assertEquals("Values do not match", expected, actual, 0);
    }

    @Test
    public void burgerGetReceiptReturnsCorrectReceipt() {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Sauce name", 60f);
    burger.addIngredient(ingredient);
    Mockito.when(bun.getName()).thenReturn("Bun name");
    Mockito.when(bun.getPrice()).thenReturn(10f);
    String expected = "(==== Bun name ====)\r\n" +
            "= sauce Sauce name =\r\n" +
            "(==== Bun name ====)\r\n" +
            "\r\n" +
            "Price: 80,000000" +
            "\r\n";
    String actual = burger.getReceipt();
    Assert.assertEquals("Values do not match", expected, actual);
    }
}
