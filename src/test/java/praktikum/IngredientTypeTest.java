package praktikum;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class IngredientTypeTest {

    @Test
    // Проверка на то, что тип ингредиента "SAUCE" не равен null
    public void testSauceIngredientNotNull() {
        // Проверка на то, что тип ингредиента "SAUCE" не равен null
        assertThat(IngredientType.SAUCE, is(notNullValue()));
    }

    @Test
    // Проверка на то, что тип ингредиента "SAUCE" не равен null
    public void testFillingIngredientNotNull() {
        assertThat(IngredientType.FILLING, is(notNullValue()));
    }
}