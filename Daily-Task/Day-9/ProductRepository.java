import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ProductRepository {

    public static void main(String[] args) {

        CrudRepository<Product, Integer> repository =
                new InMemoryRepository<>(Product::getId);

        // Load CSV seed data
        try (BufferedReader reader =
                     Files.newBufferedReader(Path.of("products.csv"))) {

            String line;
            boolean header = true;

            while ((line = reader.readLine()) != null) {

                if (header) {
                    header = false;
                    continue;
                }

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());

                repository.save(new Product(id, name, price));
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading CSV: " + e.getMessage());
            return;
        }

        System.out.println("=== All Products ===");
        for (Product product : repository.findAll()) {
            System.out.println(product);
        }

        System.out.println("\n=== Find Product ===");
        repository.findById(102).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Product not found")
        );

        System.out.println("\n=== Update Product ===");
        Product updated = new Product(102, "Wireless Mouse", 1200.00);
        System.out.println("Updated: " +
                repository.update(102, updated));

        System.out.println(repository.findById(102).orElseThrow());

        System.out.println("\n=== Delete Product ===");
        System.out.println("Deleted: " + repository.deleteById(105));

        System.out.println("\n=== Final Products ===");
        List<Product> products = repository.findAll();

        for (Product product : products) {
            System.out.println(product);
        }
    }
}