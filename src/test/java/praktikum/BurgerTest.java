package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();
    Ingredient ingredientOne = new Ingredient(IngredientType.SAUCE, "Chilly Sauce", 150);
    Ingredient ingredientSecond = new Ingredient(IngredientType.FILLING, "Roza", 100);

    @Test
    // Проверка на то, что получаем правильную булочку
    public void testSetsBunsForBurger() {
        burger.setBuns(bun);
        assertEquals("Неправильная булочка", bun, burger.bun);
    }

    @Test
    // Проверка на то, что добавляем ингредиент
    public void testAddsIngredientForBurger() {
        burger.addIngredient(ingredient);

        int actualResult = burger.ingredients.size();
        int expectedResult = 1;
        assertEquals("Не верно добавлен ингредиент", expectedResult, actualResult);
    }

    @Test
    // Проверка на то, что добавляем ингредиент
    public void testMovesIngredientFromBurger() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0, 1);

        String actualResult = burger.ingredients.get(1).name;
        String expectedResult = "Chilly Sauce";
        assertEquals("Не верный ингредиент", expectedResult, actualResult);
    }

    @Test
    // Проверка на то, что добавляем и удаляем ингредиент
    public void testRemovesIngredientFromBurger() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        int actualResult = burger.ingredients.size();
        int expectedResult = 0;
        assertEquals("Не верно удален ингредиент", expectedResult, actualResult);
    }

    @Test
    // Проверка на то, что получаем верную цену
    public void testReturnsCorrectPriceForBurger() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(10));
        Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(20));

        float expectedPrice = 40;
        float actualResult = burger.getPrice();
        assertEquals("Неверная цена", expectedPrice, actualResult, 0);
    }


    @Test
    // Проверка на то, что возвращается название
    public void testReturnsCorrectStringForBurger() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(90));
        Mockito.when(bun.getName()).thenReturn("Fried potatoes");

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(120));
        Mockito.when(ingredient.getName()).thenReturn("tomatoes");

        String actualResult = burger.getReceipt();
        String expectedValue = "(==== Fried potatoes ====)\n" + "= filling tomatoes =\n" +
                "(==== Fried potatoes ====)\n" + "\n" +
                "Price: 300.000000\n";
        assertEquals(expectedValue.replace("\r\n", "\n"), actualResult.replace("\r\n", "\n"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    // Проверка на то, что получаем исключение
    public void testMoveIngredientThrowsExceptionForInvalidIndexes() {
        burger.moveIngredient(0, 1);
    }
}