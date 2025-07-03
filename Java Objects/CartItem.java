public class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateTotalCost() {
        return price * quantity;
    }

    public void displayCart() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity + ", Total: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Notebook", 50.0, 4);
        item.displayCart();
    }
}