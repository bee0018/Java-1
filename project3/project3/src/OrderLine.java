import com.sun.org.apache.xpath.internal.operations.Or;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrderLine {

    public int productID;

    @Override
    public String toString() {
        return "OrderLine{" +
                "productID=" + productID +
                ", orderID=" + orderID +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }

    public int orderID;
    public double quantity;
    public double cost;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public ArrayList<Product> getList() {return list;}
    public ArrayList<Product> list = new ArrayList<>();

}
