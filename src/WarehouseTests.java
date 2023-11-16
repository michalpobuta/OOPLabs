import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class WarehouseTests {
    private Warehouse warehouse;
    private Product book;
    private Product videoGame;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse();
        book = new Book("Lord of the Rings", 29.99, 4.5);
        videoGame = new VideoGame("Witcher 3", 199.99, 4.9);
    }

    @Test
    void testAddingProducts() {
        warehouse.addProduct(book);
        warehouse.addProduct(videoGame);
        assertEquals(2, warehouse.numberOfProducts());
    }

    @Test
    void testRemovingProducts() {
        warehouse.addProduct(book);
        warehouse.removeProduct(book);
        assertEquals(0, warehouse.numberOfProducts());
    }

    @Test
    void testFindingProductByName() {
        warehouse.addProduct(book);
        Product found = warehouse.findProductByName("Lord of the Rings");
        assertNotNull(found);
        assertEquals("Lord of the Rings", found.getName());
    }

    @Test
    void testNotFindingProduct() {
        warehouse.addProduct(videoGame);
        Product notFound = warehouse.findProductByName("Harry Potter");
        assertNull(notFound);
    }

    @Test
    void testProductUpdate() {
        warehouse.addProduct(book);
        book.setPrice(19.99);
        Product updatedBook = warehouse.findProductByName("Lord of the Rings");
        assertEquals(19.99, updatedBook.getPrice());
    }
}