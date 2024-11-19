import praktikum.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private String name;
    private float price;
    private Bun bun;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "black bun", 100 },
                { "white bun", 200 },
                { "red bun", 300 }
        });
    }

    // Проверяем, что объект bun не равен null
    @Test
    public void testBunNotNull() {
        bun = new Bun(name, price);
        assertNotNull("Объект Bun не должен быть нулевым", bun);
    }

    // Проверяем, что имя булочки совпадает с ожидаемым
    @Test
    public void testBunName() {
        bun = new Bun(name, price);
        assertEquals("Название булочки должно совпадать", name, bun.getName());
    }

    // Проверяем, что цена булочки совпадает с ожидаемой
    @Test
    public void testBunPrice() {
        bun = new Bun(name, price);
        assertEquals("Цена булочки должна совпадать", price, bun.getPrice(), 0.001);
    }
}