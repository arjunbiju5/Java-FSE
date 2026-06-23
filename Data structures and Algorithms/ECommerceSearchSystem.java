
class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}

public class ECommerceSearchSystem {

    // 1. Linear Search: O(n) time complexity
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                System.out.println("Item found.");
                return product; // Found
            }
        }
        return null;
    }

    // 2. Binary Search: O(log n) time complexity (Requires array to be pre-sorted)
    public static Product binarySearch(Product[] products, int targetId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents potential integer overflow
            
            if (products[mid].getProductId() == targetId) {
                return products[mid];
            } else if (products[mid].getProductId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        Product[] catalog = {
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(204, "Wireless Mouse", "Electronics"),
            new Product(305, "Gaming Monitor", "Electronics"),
            new Product(409, "Leather Wallet", "Accessories"),
            new Product(512, "Running Shoes", "Apparel")
        };

        int searchId = 305;

        System.out.println("--- Executing E-Commerce Search Optimized Performance ---");
        
        long startTime = System.nanoTime();
        Product result1 = linearSearch(catalog, searchId);
        long endTime = System.nanoTime();
        System.out.println("Linear Search Result: " + result1 + " (Time: " + (endTime - startTime) + " ns)");

        startTime = System.nanoTime();
        Product result2 = binarySearch(catalog, searchId);
        endTime = System.nanoTime();
        System.out.println("Binary Search Result: " + result2 + " (Time: " + (endTime - startTime) + " ns)");
    }
}