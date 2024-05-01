package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "IngredientName", 121);

    @Test
    // Проверка на то, что получаем правильное имя ингредиента
    public void testGetValidIngredientName() {
        String expectedName = "IngredientName";
        String actualName = ingredient.getName();
        assertEquals("Неверное имя", expectedName, actualName);
    }
    @Test
    // Проверка на то, что получаем правильную цену ингредиента
    public void testGetValidIngredientPrice() {
        float expectedPrice = 120;
        float actualPrice = ingredient.getPrice();
        assertEquals("Неверная цена", expectedPrice, actualPrice, 20);
    }


    @Test
    // Проверка на то, что получаем правильный тип ингредиента
    public void testGetValidIngredientType() {
        IngredientType expectedType = IngredientType.FILLING;
        IngredientType actualType = ingredient.getType();
        assertEquals("Неверный тип", expectedType, actualType);
    }
}