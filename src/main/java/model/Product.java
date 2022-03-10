package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
   private final String productName;
   private final String productCategory;
   private final double price;
   private AtomicInteger quantity = new AtomicInteger(0);

    public Product(String productName, String productCategory, double price, int quantity) {
       this.productName = productName;
       this.productCategory = productCategory;
       this.price = price;
       this.quantity.set(quantity);
   }

    public String getProductName() {return productName;}

    public String getProductCategory() {
        return productCategory;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {return quantity.get();}

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
