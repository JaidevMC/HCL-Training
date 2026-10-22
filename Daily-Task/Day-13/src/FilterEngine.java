
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private boolean inStock;

    public Product(int id, String name, String category,
                   double price, boolean inStock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isInStock() {
        return inStock;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println(
            id + " | " + name + " | " + category
            + " | Rs." + price + " | In stock: " + inStock
        );
    }
}

@FunctionalInterface
interface ProductCheck {
    boolean test(Product product);
}

public class FilterEngine {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product(101, "Laptop", "Electronics", 55000, true));
        products.add(new Product(102, "Mouse", "Electronics", 750, true));
        products.add(new Product(103, "Chair", "Furniture", 3500, false));
        products.add(new Product(104, "Keyboard", "Electronics", 1500, true));
        products.add(new Product(105, "Table", "Furniture", 7000, true));

        // Predicate: check price
        Predicate<Product> priceCheck =
                p -> p.getPrice() < 10000;

        // Predicate: check category
        Predicate<Product> categoryCheck =
                p -> p.getCategory().equals("Electronics");

        // Predicate: check stock
        Predicate<Product> stockCheck =
                Product::isInStock;

        // Compose predicates
        Predicate<Product> filter =
                priceCheck.and(categoryCheck).and(stockCheck);

        System.out.println("=== Filtered Products ===");

        // Consumer: display each product
        Consumer<Product> displayProduct = Product::display;

        products.stream()
                .filter(filter)
                .forEach(displayProduct);

        // Function chain: transform product name
        Function<Product, String> getName = Product::getName;

        Function<String, String> formatName =
                name -> "Product: " + name.toUpperCase();

        Function<Product, String> nameFormatter =
                getName.andThen(formatName);

        System.out.println("\n=== Formatted Product Names ===");

        products.stream()
                .map(nameFormatter)
                .forEach(System.out::println);

        // Supplier: create a default product
        Supplier<Product> defaultProduct =
                () -> new Product(106, "Pen", "Stationery", 20, true);

        System.out.println("\n=== Default Product ===");
        defaultProduct.get().display();

        // Custom functional interface
        ProductCheck affordable =
                p -> p.getPrice() < 2000;

        System.out.println("\n=== Affordable Products ===");

        products.stream()
                .filter(affordable::test)
                .forEach(Product::display);

        // Predicate negate
        System.out.println("\n=== Out of Stock Products ===");

        products.stream()
                .filter(stockCheck.negate())
                .forEach(Product::display);

        // Predicate or
        System.out.println("\n=== Electronics or Furniture ===");

        Predicate<Product> furnitureCheck =
                p -> p.getCategory().equals("Furniture");

        products.stream()
                .filter(categoryCheck.or(furnitureCheck))
                .forEach(Product::display);
    }
}
