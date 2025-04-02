package tests.lesson9;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Category;
import model.CoffeeShop;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JsonParserTest {

    @Test
    void testJsonParsing() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("menu.json")) {
            assertNotNull(is, "Файл menu.json не найден!");

            ObjectMapper objectMapper = new ObjectMapper();
            CoffeeShop coffeeShop = objectMapper.readValue(is, CoffeeShop.class);

            assertEquals("Арома Кофе", coffeeShop.getName());
            assertEquals(2, coffeeShop.getMenu().size());

            Category coffeeCategory = coffeeShop.getMenu().get(0);
            assertEquals("Кофе", coffeeCategory.getCategory());
            assertEquals("Эспрессо", coffeeCategory.getItems().get(0).getName());
            assertEquals(150, coffeeCategory.getItems().get(0).getPrice());

            Category teaCategory = coffeeShop.getMenu().get(1);
            assertEquals("Чай", teaCategory.getCategory());
            assertEquals("Черный чай", teaCategory.getItems().get(0).getName());
            assertEquals(180, teaCategory.getItems().get(0).getPrice());
        }
    }
}
