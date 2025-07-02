class Order {
    int orderId; String orderDate;
    Order(int id,String date){ orderId=id; orderDate=date; }
    String getOrderStatus(){ return "Order Placed"; }
}
class ShippedOrder extends Order{
    String trackingNumber;
    ShippedOrder(int id,String date,String track){ super(id,date); trackingNumber=track;}
    @Override String getOrderStatus(){ return "Shipped: "+trackingNumber; }
}
class DeliveredOrder extends ShippedOrder{
    String deliveryDate;
    DeliveredOrder(int id,String date,String track,String delivery){ super(id,date,track); deliveryDate=delivery;}
    @Override String getOrderStatus(){ return "Delivered on "+deliveryDate; }
}
public class OnlineRetailOrder{
    public static void main(String[]args){
        DeliveredOrder d=new DeliveredOrder(1001,"2025-07-02","TRK123","2025-07-05");
        System.out.println(d.getOrderStatus());
    }
}