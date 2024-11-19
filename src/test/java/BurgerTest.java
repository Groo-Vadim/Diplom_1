import praktikum.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BurgerTest {
    // экземпляр бургера, который мы будем тестировать
    private Burger burger;
    // экземпляр булки
    private Bun bun;
    // экземпляр начинки
    private Ingredient filling;
    // экземпляр соуса
    private Ingredient sauce;

    @Before
    public void setUp() {

        //Инициализируем новый бургер и необходимые ингредиенты перед каждым тестом
        burger = new Burger();
        bun = new Bun("black bun", 100);
        filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        sauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

        // Устанавливаем булку для бургера
        burger.setBuns(bun);
    }
    // Тестируем добавление булки
    @Test
    public void testBunsName() {
        // Проверяем, что имя булки установлено правильно
        assertEquals("black bun", burger.bun.getName());
    }

    // Тестируем добавление булки
    @Test
    public void testBunsNPrice() {
        // Проверяем, что цена булки установлена правильно
        assertEquals(100, burger.bun.getPrice(), 0);
    }

    // Тестируем добавление ингредиентов
    @Test
    public void testAddIngredient() {
        // Добавляем начинку
        burger.addIngredient(filling);
        // Добавляем соус
        burger.addIngredient(sauce);
        // Проверяем, что два ингредиента добавлены в бургер
        assertEquals(2, burger.ingredients.size());
    }

    // Тестируем удаление ингредиентов
    @Test
    public void testRemoveIngredient() {
        // Добавляем начинку
        burger.addIngredient(filling);
        // Добавляем соус
        burger.addIngredient(sauce);
        // Проверяем, что два ингредиента добавлены
        assertEquals(2, burger.ingredients.size());
        // Удаляем ингредиент по индексу
        // Удаляем первый ингредиент (начинка)
        burger.removeIngredient(0);
        // Проверяем, что остался один ингредиент
        assertEquals(1, burger.ingredients.size());
        // Проверяем, что осталась только "hot sauce"
        assertEquals("hot sauce", burger.ingredients.get(0).getName());
    }

    // Тестируем перемещение ингредиентов
    @Test
    public void testMoveIngredient() {
        // Добавляем начинку (индекс 0)
        burger.addIngredient(filling);
        // Добавляем соус (индекс 1)
        burger.addIngredient(sauce);
        // Перемещаем ингредиент в список
        // Перемещаем начинку на вторую позицию (индекс 1)
        burger.moveIngredient(0, 1);
        // Проверяем, что на новой позиции находится "cutlet"
        assertEquals("cutlet", burger.ingredients.get(1).getName());
        // Проверяем, что на первой позиции остался "hot sauce"
        assertEquals("hot sauce", burger.ingredients.get(0).getName());
    }

    // Тестируем расчет итоговой цены бургера
    @Test
    public void testGetPrice() {
        // добавляем начинку
        burger.addIngredient(filling);
        // добавляем соус
        burger.addIngredient(sauce);
        // Цена = 100 (булка) * 2 + 100 (начинка) + 100 (соус)
        // Проверяем, что итоговая цена равна 400
        assertEquals(400, burger.getPrice(), 0);
    }

    // Тестируем создание чека
    @Test
    public void testGetReceipt() {
        // добавляем начинку
        burger.addIngredient(filling);
        // добавляем соус
        burger.addIngredient(sauce);
        // Формируем ожидаемый чек
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), filling.getName()) +
                String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(), sauce.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        // Проверяем, что полученный чек соответствует ожидаемому
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}