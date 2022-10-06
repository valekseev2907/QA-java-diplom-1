import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void bunGetNameReturnsName() {
        String name = "Cosmo bun";
        Bun bun = new Bun(name, 15f);
        String actual = bun.getName();
        Assert.assertEquals("Values do not match", name, actual);
    }

    @Test
    public void bunGetPriceReturnsPrice() {
        float price = 15f;
        Bun bun = new Bun("Cosmo bun", price);
        float actual = bun.getPrice();
        Assert.assertEquals("Values do not match", price, actual, 0);
    }
}
