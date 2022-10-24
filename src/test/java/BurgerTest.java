import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void burgerAddIngredientAddsIngredient() {
        Ingredient expected = firstIngredient;
        burger.addIngredient(expected);
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("Values do not match", expected, actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void burgerRemoveIngredientRemovesIngredient() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("Values or exceptions types do not match", IndexOutOfBoundsException.class, actual);
    }

    @Test
    public void burgerMoveIngredientMovesIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0,1);
        Ingredient actual = burger.ingredients.get(1);
        Assert.assertEquals("Values do not match", firstIngredient, actual);
    }

    @Test
    public void burgerGetPriseReturnsCorrectPrice() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(firstIngredient.getPrice()).thenReturn(35f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(40f);
        Mockito.when(bun.getPrice()).thenReturn(25f);
        float actual = burger.getPrice();
        float expected = 125f;
        Assert.assertEquals("Values do not match", expected, actual, 0);
    }

    @Test
    public void burgerGetReceiptReturnsCorrectReceipt() {
    burger.addIngredient(firstIngredient);
    Mockito.when(firstIngredient.getType()).thenReturn(SAUCE);
    Mockito.when(firstIngredient.getName()).thenReturn("Кептчук");
    Mockito.when(firstIngredient.getPrice()).thenReturn(60f);
    Mockito.when(bun.getName()).thenReturn("Bun name");
    Mockito.when(bun.getPrice()).thenReturn(10f);
    String expected = "(==== Bun name ====)\r\n" +
            "= sauce Кептчук =\r\n" +
            "(==== Bun name ====)\r\n" +
            "\r\n" +
            "Price: 80,000000" +
            "\r\n";
    String actual = burger.getReceipt();
    Assert.assertEquals("Values do not match", expected, actual);
    }
}
