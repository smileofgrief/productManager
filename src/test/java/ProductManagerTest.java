import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "Преступление и наказание", 300, "Ф.М.Достоевский");
    Product product2 = new Book(2, "1984", 1000, "Джордж Оруэлл");
    Product product3 = new Book(3, "Война и мир.1 Том", 450, "Л.Н. Толстой");
    Product product4 = new Book(44, "Война и мир.2 Том", 500, "Л.Н. Толстой");
    Product product5 = new SmartPhone(5, "iPhone 14", 200_000, "Apple");
    Product product6 = new SmartPhone(6, "Galaxy S22", 130_000, "Samsung");
    Product product7 = new SmartPhone(7, "Xiaomi 13", 25_000, "Xiaomi");
    Product product8 = new SmartPhone(8, "Xiaomi 11 Pro", 30_000, "Xiaomi");

    @BeforeEach
    public void before() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
    }

    @Test
    public void findBookByName() {
        Product[] expected = new Product[]{product2};
        Product[] actual = manager.searchBy("1984");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findNonExistentBookByName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Колобок");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findMultipleBooksByName() {
        Product[] expected = {product3, product4};
        Product[] actual = manager.searchBy("мир");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findSmartphoneByName() {
        Product[] expected = new Product[]{product6};
        Product[] actual = manager.searchBy("Galaxy");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findNonExistentSmartphoneByName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Oppo");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findMultipleSmartphonesByName() {
        Product[] expected = {product7, product8};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByName() {
        boolean expected = true;
        boolean actual = manager.matches(product2, "1984");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByAuthor() {
        boolean expected = false;
        boolean actual = manager.matches(product3, "Толстой");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName() {
        boolean expected = true;
        boolean actual = manager.matches(product8, "Xiaomi 11 Pro");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByManufacture() {
        boolean expected = false;
        boolean actual = manager.matches(product5, "Apple");
        assertEquals(expected, actual);
    }
}

