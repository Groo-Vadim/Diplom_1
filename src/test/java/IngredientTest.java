import praktikum.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    // Экземпляр ингредиента, который мы будем тестировать
    private Ingredient ingredient;

    @Before
    public void setUp() {

        // Мы инициализируем новый ингредиент перед каждым тестом
        ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    }

    // Тестируем конструктор класса Ingredient
    @Test
    public void testConstructor() {
        // Создаем новый ингредиент
        Ingredient testIngredient = new Ingredient(IngredientType.SAUCE, "tomato sauce", 150);
        // Проверяем, что тип установлен правильно
        assertEquals(IngredientType.SAUCE, testIngredient.getType());
        // Проверяем, что имя установлено правильно
        assertEquals("tomato sauce", testIngredient.getName());
        // Проверяем, что цена установлена правильно
        assertEquals(150, testIngredient.getPrice(), 0);
    }

    // Тестируем метод получения имени
    @Test
    public void testGetName() {
        // Проверяем, что имя ингредиента установлено правильно
        assertEquals("cutlet", ingredient.getName());
    }

    // Тестируем метод получения типа
    @Test
    public void testGetType() {
        // Проверяем, что тип ингредиента установлен правильно
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    // Тестируем метод получения цены
    @Test
    public void testGetPrice() {
        // Проверяем, что цена ингредиента установлена правильно
        assertEquals(100, ingredient.getPrice(), 0);
    }
}