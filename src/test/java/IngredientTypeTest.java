import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String expectedName;
    private final IngredientType ingredientType;

    public IngredientTypeTest(String expectedName, IngredientType ingredientType) {
        this.expectedName = expectedName;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "FILLING", IngredientType.FILLING },
                { "SAUCE", IngredientType.SAUCE }
        });
    }

    //Тестируем, что типы имеют корректные названия
    @Test
    public void testIngredientTypeNames() {
        assertEquals("Тип начинки должен иметь правильное название.", expectedName, ingredientType.name());
    }

    //Тестируем, что количество типов соответствует ожиданиям
    @Test
    public void testIngredientTypeCount() {
        IngredientType[] types = IngredientType.values();
        // Проверяем, что у нас только 2 типа
        assertEquals("Ингредиентов должны быть 2", 2, types.length);
    }
}