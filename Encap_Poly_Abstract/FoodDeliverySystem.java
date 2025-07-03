// Problem 6 – Online Food Delivery System
abstract class FoodItemFD {
    private String itemName;
    private double price;
    private int quantity;
    FoodItemFD(String name, double price, int quantity) {
        this.itemName = name;
        this.price = price;
        this.quantity = quantity;
    }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void getItemDetails() {
        System.out.println(itemName + " | Price: " + price + " | Qty: " + quantity);
    }
    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount(double percentage);
    String getDiscountDetails();
}

class VegItem extends FoodItemFD implements Discountable {
    VegItem(String name, double price, int qty) { super(name, price, qty); }
    @Override public double calculateTotalPrice() { return getPrice() * getQuantity(); }
    @Override public double applyDiscount(double pct) { return calculateTotalPrice() * (pct / 100); }
    @Override public String getDiscountDetails() { return "Veg discount applied"; }
}

class NonVegItem extends FoodItemFD implements Discountable {
    NonVegItem(String name, double price, int qty) { super(name, price, qty); }
    @Override public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        return base + base * 0.10; // 10% non‑veg extra charge
    }
    @Override public double applyDiscount(double pct) { return calculateTotalPrice() * (pct / 100); }
    @Override public String getDiscountDetails() { return "Non‑Veg discount applied"; }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItemFD[] order = { new VegItem("Paneer Curry", 200, 2), new NonVegItem("Chicken Biryani", 250, 1) };
        for (FoodItemFD f : order) {
            f.getItemDetails();
            System.out.println("Total: " + f.calculateTotalPrice());
        }
    }
}