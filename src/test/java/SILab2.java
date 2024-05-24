import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class SILab2Test {

    @Test
    void testAllItemsNull() {
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> SILab2.checkCart(null, 100),
                "Expected checkCart(null, 100) to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("allItems list can't be null!"));
    }

    @Test
    void testGetBarcodeNotNullOrNameLengthZero() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("", "12345", 100, 0.0f));
        assertDoesNotThrow(() -> {
            boolean result = SILab2.checkCart(items, 100);
            assertEquals("unknown", items.get(0).getName());
            assertTrue(result);
        });
    }

    @Test
    void testBarcodeNotNull() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "12345", 100, 0.0f));
        items.add(new Item("item2", "67890", 200, 0.2f));
        assertDoesNotThrow(() -> {
            boolean result = SILab2.checkCart(items, 150);
            assertFalse(result);
        });
    }

    @Test
    void testSumLessThanOrEqualPayment() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "12345", 50, 0.0f));
        items.add(new Item("item2", "67890", 50, 0.0f));
        assertDoesNotThrow(() -> {
            boolean result = SILab2.checkCart(items, 100);
            assertTrue(result);
        });
    }

    @Test
    void testItemNameNullOrLengthZero() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(null, "12345", 100, 0.0f));
        items.add(new Item("", "67890", 200, 0.0f));
        assertDoesNotThrow(() -> {
            boolean result = SILab2.checkCart(items, 300);
            assertEquals("unknown", items.get(0).getName());
            assertEquals("unknown", items.get(1).getName());
            assertTrue(result);
        });
    }

    @Test
    void testItemPriceGreaterThan300DiscountGreaterThan0BarcodeStartsWith0() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "012345", 350, 0.1f));
        assertDoesNotThrow(() -> {
            boolean result = SILab2.checkCart(items, 35);
            assertTrue(result);
        });
    }
}
