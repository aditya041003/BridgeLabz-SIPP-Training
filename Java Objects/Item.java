public class Item {
    int itemCode;
    String itemName;
    double price;

    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayItemDetails(int quantity) {
        System.out.println("Item Code: " + itemCode + ", Name: " + itemName + ", Price per unit: " + price);
        System.out.println("Total Cost: " + (price * quantity));
    }

    public static void main(String[] args) {
        Item item = new Item(101, "Pen", 10.5);
        item.displayItemDetails(3);
    }
}