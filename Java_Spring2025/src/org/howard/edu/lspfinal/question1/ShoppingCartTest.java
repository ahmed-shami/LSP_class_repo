package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test for adding valid item")
    void testAddValidItem() {
        cart.addItem("Book", 19.99);
        assertEquals(19.99, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    void testAddItemWithZeroPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("FreeItem", 0.0);
        });
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    void testAddItemWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("BadItem", -5.00);
        });
    }

    @Test
    @DisplayName("Test for applying 'SAVE10'")
    void testApplySave10() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 0.001);
    }

    @Test
    @DisplayName("Test for applying 'SAVE20'")
    void testApplySave20() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 0.001);
    }

    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    void testApplyInvalidCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
    }

    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Pen", 2.00);
        cart.addItem("Notebook", 3.00);
        assertEquals(5.00, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Laptop", 1000.00);
        cart.applyDiscountCode("SAVE10");
        assertEquals(900.00, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test removing existing item")
    void testRemoveExistingItem() {
        cart.addItem("Headphones", 50.0);
        assertTrue(cart.removeItem("Headphones"));
        assertEquals(0, cart.getCartSize());
    }

    @Test
    @DisplayName("Test removing non-existent item")
    void testRemoveNonExistentItem() {
        cart.addItem("Mouse", 25.0);
        assertFalse(cart.removeItem("Keyboard"));
        assertEquals(1, cart.getCartSize());
    }

    @Test
    @DisplayName("Test cart size updates after adding/removing")
    void testCartSizeUpdate() {
        cart.addItem("Monitor", 150.0);
        cart.addItem("Webcam", 75.0);
        assertEquals(2, cart.getCartSize());
        cart.removeItem("Monitor");
        assertEquals(1, cart.getCartSize());
    }
}
