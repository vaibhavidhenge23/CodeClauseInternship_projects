import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shopping_cart {

    public static void main(String[] args) {
     
        String[] productNames = {"Laptop", "Smartphone", "Headphones", "Smartwatch"};
        double[] productPrices = {800.00, 500.00, 100.00, 200.00};

        List<Integer> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Simple E-Commerce System!");
            System.out.println("1. View Products");
            System.out.println("2. View Cart");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nAvailable Products:");
                    for (int i = 0; i < productNames.length; i++) {
                        System.out.printf("%d. %s - $%.2f%n", i + 1, productNames[i], productPrices[i]);
                    }
                }
                case 2 -> {
                    if (cart.isEmpty()) {
                        System.out.println("\nYour cart is empty.");
                    } else {
                        System.out.println("\nYour Cart:");
                        double total = 0;
                        for (int productId : cart) {
                            System.out.printf("- %s: $%.2f%n", productNames[productId], productPrices[productId]);
                            total += productPrices[productId];
                        }
                        System.out.printf("Total: $%.2f%n", total);
                    }
                }
                case 3 -> {
                    System.out.print("\nEnter Product Number to Add: ");
                    int productId = scanner.nextInt() - 1;
                    if (productId >= 0 && productId < productNames.length) {
                        cart.add(productId);
                        System.out.println(productNames[productId] + " added to your cart.");
                    } else {
                        System.out.println("Invalid product number!");
                    }
                }
                case 4 -> {
                    System.out.print("\nEnter Product Number to Remove: ");
                    int productId = scanner.nextInt() - 1;
                    if (cart.remove((Integer) productId)) {
                        System.out.println(productNames[productId] + " removed from your cart.");
                    } else {
                        System.out.println("Product not found in your cart!");
                    }
                }
                case 5 -> { // Checkout
                    if (cart.isEmpty()) {
                        System.out.println("\nYour cart is empty!");
                    } else {
                        double total = 0;
                        System.out.println("\n Your Cart:");
                        for (int productId : cart) {
                            System.out.printf("- %s: $%.2f%n", productNames[productId], productPrices[productId]);
                            total += productPrices[productId];
                        }
                        System.out.printf("Total: $%.2f%n", total);
                        System.out.print("Proceed to checkout? (yes/no): ");
                        String confirm = scanner.next();
                        if (confirm.equalsIgnoreCase("yes")) {
                            System.out.println("Thank you for your purchase!");
                            cart.clear();
                        } else {
                            System.out.println("Checkout canceled.");
                        }
                    }
                }
                case 6 -> { // Exit
                    System.out.println("Thank you for visiting! ");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }
}
