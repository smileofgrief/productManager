import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

    public class ProductRepositoryTest {
        ProductRepository repository = new ProductRepository();

        Product product1 = new Book(1, "Преступление и наказание", 300, "Ф.М.Достоевский");
        Product product2 = new Book(2, "1984", 1000, "Джордж Оруэлл");
        Product product3 = new Book(3, "Война и мир.1 Том", 450, "Л.Н. Толстой");
        Product product4 = new Book(44, "Война и мир.2 Том", 500, "Л.Н. Толстой");
        Product product5 = new SmartPhone(5, "iPhone 14", 200_000, "Apple");
        Product product6 = new SmartPhone(6, "Galaxy S22", 130_000, "Samsung");
        Product product7 = new SmartPhone(7, "Xiaomi 13", 25_000, "Xiaomi");
        Product product8 = new SmartPhone(8, "Xiaomi 11 Pro", 30_000, "Xiaomi");

        @Test
        public void findEmpty() {
            Product[] expected = {};
            Product[] actual = repository.findAll();
            assertArrayEquals(expected, actual);
        }

        @Test
        public void AddOnlyBooks() {
            repository.add(product1);
            repository.add(product2);
            repository.add(product3);
            repository.add(product4);
            Product[] expected = {product1, product2, product3, product4};
            Product[] actual = repository.findAll();
            assertArrayEquals(expected, actual);
        }
        @Test
        public void AddOnlySmartphone() {
            repository.add(product5);
            repository.add(product6);
            repository.add(product7);
            repository.add(product8);
            Product[] expected = {product5, product6, product7, product8};
            Product[] actual = repository.findAll();
            assertArrayEquals(expected, actual);
        }
        @Test
        public void removeExistingProductFromArray() {
            repository.add(product1);
            repository.add(product2);
            repository.add(product3);
            repository.add(product4);
            repository.removeByID(3);
            Product[] expected = {product1, product2, product4};
            Product[] actual = repository.findAll();
            assertArrayEquals(expected, actual);
        }

        @Test
        public void removeNotExistingProductFromArray() {
            repository.add(product1);
            repository.add(product2);
            repository.add(product3);
            repository.add(product4);
            assertThrows(RuntimeException.class, () -> {
                repository.removeByID(9);
            });
        }

        @Test
        public void shouldSave() {
            repository.add(product1);
            repository.add(product2);
            repository.add(product3);
            repository.add(product4);
            repository.add(product8);
            Product[] expected = {product1, product2, product3, product4, product8};
            Product[] actual = repository.findAll();
            assertArrayEquals(expected, actual);
        }
    }

