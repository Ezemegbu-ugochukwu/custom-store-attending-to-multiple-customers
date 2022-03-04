package operations;

import exceptions.CannotJoinQueueTwice;
import exceptions.NotTheExactQuantityException;
import exceptions.OutOfStockException;
import model.Customer;
import model.Store;

public interface CustomerOperations extends CommonOperations {
    void addToCart(Store store, Customer customer, String productName, int quantity) throws OutOfStockException;
    void removeFromCart(Customer customer, String productName, int quantity) throws NotTheExactQuantityException;
    void joinQueue (Store store, Customer customer) throws CannotJoinQueueTwice;
}

