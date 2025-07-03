// Sample Program 4 – Shopping Cart System
class Product {
    private static double discount = 10.0; // in percent

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to " + discount + "%");
    }

    public double getFinalPrice() {
        return price * quantity * (1 - discount / 100);
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("ID: " + productID + " | Name: " + productName +
                               " | Qty: " + quantity + " | Unit Price: " + price +
                               " | Final Price: " + getFinalPrice());
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 60000, 1);
        Product p2 = new Product(102, "Mouse", 500, 2);
        p1.displayDetails();
        p2.displayDetails();
        Product.updateDiscount(15);
        p1.displayDetails();
    }
}