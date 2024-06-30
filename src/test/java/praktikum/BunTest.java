package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    Bun bun = new Bun("BunName", 99);

    @Test
    // Проверка на то, что получаем правильное имя
    public void testGetValidName() {
        String expectedName = "BunName";
        String actualName = bun.getName();
        assertEquals("Неверное имя", expectedName, actualName);
    }
    @Test
    // Проверка на то, что получаем правильную цену
    public void testGetValidPrice() {
        float expectedPrice = 99;
        float actualPrice = bun.getPrice();
        assertEquals("Неверная цена", expectedPrice, actualPrice, 0);
    }


}