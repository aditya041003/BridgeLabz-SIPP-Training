// Problem 2 – E‑Commerce Platform
abstract class Product {
    private int productId;
    private String name;
    private double price;

    Product(int id, String name, double price) {
        this.productId = id;
        this.name = name;
        this.price = price;
    }
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double p) { this.price = p; }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    Electronics(int id, String name, double price) { super(id, name, price); }
    @Override public double calculateDiscount() { return getPrice() * 0.10; } // 10% discount
    @Override public double calculateTax() { return getPrice() * 0.18; } // 18% GST
    @Override public String getTaxDetails() { return "GST 18%"; }
}

class Clothing extends Product implements Taxable {
    Clothing(int id, String name, double price) { super(id, name, price); }
    @Override public double calculateDiscount() { return getPrice() * 0.15; } // 15% discount
    @Override public double calculateTax() { return getPrice() * 0.05; } // 5% VAT
    @Override public String getTaxDetails() { return "VAT 5%"; }
}

class Groceries extends Product {
    Groceries(int id, String name, double price) { super(id, name, price); }
    @Override public double calculateDiscount() { return 0; }
}

public class ECommercePlatform {
    static double finalPrice(Product p) {
        double price = p.getPrice();
        double discount = p.calculateDiscount();
        double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
        return price + tax - discount;
    }
    public static void main(String[] args) {
        Product[] items = {
            new Electronics(101, "Laptop", 60000),
            new Clothing(102, "T‑Shirt", 1000),
            new Groceries(103, "Rice 10kg", 600)
        };
        for (Product p : items) {
            System.out.println(p.getName() + " | Final Price: " + finalPrice(p));
        }
    }
}