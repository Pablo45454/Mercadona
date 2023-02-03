package com.mercadona.shopone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MercadonaShopOneTest {
    
    @Test
    void itemGenericoNoCaducado2() {
        Item[] items = new Item[] { new Item("Bread", 3, 12) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Bread", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    void itemGenericoCaducado2() {
        Item[] items = new Item[] { new Item("Bread", -1, 32) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Bread", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
    }

    @Test
    void itemGenericoNoCaducado() {
        Item[] items = new Item[] { new Item("Frozen cake", 3, 12) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Frozen cake", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }
    
    @Test
    void itemGenericoCaducado() {
        Item[] items = new Item[] { new Item("Frozen cake", -1, 32) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Frozen cake", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(28, app.items[0].quality);
    }
    
    @Test
    void itemSalt() {
        Item[] items = new Item[] { new Item("Iodized salt", -1, 70) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Iodized salt", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(70, app.items[0].quality);
    }
    
    @Test
    void itemBlueCheese() {
        Item[] items = new Item[] { new Item("Aged blue cheese", 4, 60) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Aged blue cheese", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
     @Test
    void itemBlueCheeseExpired() {
        Item[] items = new Item[] { new Item("Aged blue cheese", -1, 60) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Aged blue cheese", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void itemHam() {
        Item[] items = new Item[] { new Item("Ham", 15, 53) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Ham", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
     @Test
    void itemHamExpired() {
        Item[] items = new Item[] { new Item("Ham", -3, 20) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Ham", app.items[0].name);
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    

}
