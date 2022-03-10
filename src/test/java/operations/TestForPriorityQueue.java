//package operations;
//
//import enums.Designation;
//import enums.Gender;
//import exceptions.CannotJoinQueueTwice;
//import exceptions.InsufficientFundException;
//import exceptions.OutOfStockException;
//import exceptions.StaffNotAuthorizedException;
//import model.Customer;
//import model.Staff;
//import model.Store;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class TestForPriorityQueue {
//    Store ugoBossStore = new Store("Decagon");
//    Customer ugo = new Customer("ugo","Eze", Gender.MALE,5000000.00);
//    Customer moses = new Customer("moses","Eze", Gender.MALE,5000000.00);
//    Customer ben = new Customer("ben","Eze", Gender.MALE,5000000.00);
//    Customer charles = new Customer("charles","Eze", Gender.MALE,5000000.00);
//    Customer love = new Customer("love","Eze", Gender.MALE,5000000.00);
//
//    Staff manager = new Staff("Chukuka", "Ebuka", Gender.MALE, Designation.MANAGER);
//    Staff cashier = new Staff("Mope", "Oke", Gender.FEMALE, Designation.CASHIER);
//    String excelFilePath = "src/main/resources/excelFiles/hugo_store.xlsx";
//    CustomerOperationImpl customerOperationImpl = new CustomerOperationImpl();
//    AdminOperationImpl adminOperation = new AdminOperationImpl();
//
//
//
//    @Before
//    public void setUp() throws StaffNotAuthorizedException, OutOfStockException, CannotJoinQueueTwice {
//        adminOperation.addProductsToStore(ugoBossStore, manager);
////        System.out.println(ugoBossStore.getStocks());
//        customerOperationImpl.addToCart(ugoBossStore,love,"MacBook pro",10);  //3
//        customerOperationImpl.addToCart(ugoBossStore,ben,"Iphone",5);//5
//        customerOperationImpl.addToCart(ugoBossStore,ugo,"MacBook pro",7);  //2
//        customerOperationImpl.addToCart(ugoBossStore,moses,"Hp EliteBook",15);  //1
//        customerOperationImpl.addToCart(ugoBossStore,charles,"Tecno Camera",1); //4
//
//        customerOperationImpl.joinQueue(ugoBossStore,moses);
//        customerOperationImpl.joinQueue(ugoBossStore,love);
//        customerOperationImpl.joinQueue(ugoBossStore,charles);
//        customerOperationImpl.joinQueue(ugoBossStore,ugo);
//        customerOperationImpl.joinQueue(ugoBossStore,ben);
//
//
//
//        adminOperation = new AdminOperationImpl();
//        adminOperation.addProductsToStore(ugoBossStore, manager);
//    }
//    @Test
//    public void PriorityShouldBeBasedOnFIFOAndQuantity(){
//        assertEquals(moses, ugoBossStore.getCustomersQueue().poll());
//        assertEquals(ugo, ugoBossStore.getCustomersQueue().poll());
//        assertEquals(love, ugoBossStore.getCustomersQueue().poll());
//     assertEquals(charles, ugoBossStore.getCustomersQueue().poll());
//     assertEquals(ben, ugoBossStore.getCustomersQueue().poll());
//
//    }
////    @Test
////    public void testForSellingToCustomerOnQueue () throws StaffNotAuthorizedException, InsufficientFundException {
////        assertFalse(ugoBossStore.getCustomersQueue().isEmpty());
////        adminOperation.sellToCustomersInQueue(ugoBossStore, cashier);
////        assertTrue(ugoBossStore.getCustomersQueue().isEmpty());
////    }
//    @Test
//    public void testForCustomerJoiningQueueMoreThanOnce(){
//        Exception exception = assertThrows(CannotJoinQueueTwice.class,
//                ()->customerOperationImpl.joinQueue(ugoBossStore, moses));
//        assertEquals("Customer is on the queue already", exception.getMessage());
//    }
//
//
//
//
//
//}
