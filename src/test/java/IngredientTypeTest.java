import praktikum.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class IngredientTypeTest {

    //Тестируем, что типы имеют корректные названия FILLING
    @Test
    public void testIngredientTypeNamesFilling() {
        assertEquals("Тип начинки должен иметь правильное название.", "FILLING", IngredientType.FILLING.name());
    }

    //Тестируем, что типы имеют корректные названия SAUCE
    @Test
    public void testIngredientTypeNamesSauce() {
       assertEquals("Тип соуса должен иметь правильное название.", "SAUCE", IngredientType.SAUCE.name());
    }

    //Тестируем, что количество типов соответствует ожиданиям
    @Test
    public void testIngredientTypeCount() {
        IngredientType[] types = IngredientType.values();
        // Проверяем, что у нас только 2 типа
        assertEquals("Ингредиентов должны быть 2", 2, types.length);
    }
}