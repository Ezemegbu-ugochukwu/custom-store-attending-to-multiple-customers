package operations;

import exceptions.*;
import model.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SellToCustomerThread {
    AdminOperations adminOperations = new AdminOperationImpl();

    public void sell (Store store, Staff staff) {


        ExecutorService executorService = Executors.newFixedThreadPool(2);
             for (Customer customer : store.getCustomersQueue()){
            executorService.execute(()->{
                try {
                    System.out.println("Selling to " + customer.getFirstName() +  " using "
                                        + Thread.currentThread().getName());
                    adminOperations.sellProduct(store, staff, customer);
                } catch (InsufficientFundException | CustomerNotCheckedOutException | StaffNotAuthorizedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
