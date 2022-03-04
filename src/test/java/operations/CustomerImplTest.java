package operations;

import enums.Designation;
import enums.Gender;
import exceptions.InsufficientFundException;
import exceptions.NotTheExactQuantityException;
import exceptions.OutOfStockException;
import exceptions.StaffNotAuthorizedException;
import model.Customer;
import model.Staff;
import model.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerImplTest {
    Store ugoBossStore = new Store("Decagon");
    Customer customer = new Customer("ugo","Eze", Gender.MALE,5000000.00);
    Staff manager = new Staff("Chukuka", "Ebuka", Gender.MALE, Designation.MANAGER);
    Staff cashier = new Staff("Mope", "Oke", Gender.FEMALE, Designation.CASHIER);
    String excelFilePath = "src/main/resources/excelFiles/hugo_store.xlsx";
    CustomerOperationImpl customerOperationImpl;
    AdminOperationImpl adminOperation;


   @Before
    public void setUp() throws StaffNotAuthorizedException {
        customerOperationImpl = new CustomerOperationImpl();
        adminOperation = new AdminOperationImpl();
       adminOperation.addProductsToStore(ugoBossStore, manager);

   }

    @Test
    public void productShouldBeSuccessfullyAddedToCart() throws OutOfStockException {
        customerOperationImpl.addToCart(ugoBossStore, customer, "MacBook pro", 6);
        assertTrue(customer.getCart().containsKey("MacBook pro"));
    }
    @Test
    public void shouldRemoveFromCartSuccessfully() throws OutOfStockException, NotTheExactQuantityException {
       customerOperationImpl.addToCart(ugoBossStore, customer, "MacBook pro", 2 );
       customerOperationImpl.removeFromCart(customer,"MacBook pro",1);
       assertEquals(1, customer.getCart().size());

    }

    @Test
    public void shouldThrowExceptionWhenCompanyDoestHaveGoods() {
        assertThrows(OutOfStockException.class, () ->customerOperationImpl.addToCart(ugoBossStore, customer, "Xbox", 6));
    }

    @Test
    public void shouldThrowOutOfStockExceptionWhenGoodsIsFinishedOrZero() throws OutOfStockException, StaffNotAuthorizedException, InsufficientFundException {
        Customer customer2 = new Customer("Moses", "Elliot", Gender.MALE, 800_000);
        customer.setWalletBalance(13_000_000);
        customerOperationImpl.addToCart(ugoBossStore, customer, "MacBook pro", 50);
        adminOperation.sellProduct(ugoBossStore, cashier, customer);
        assertThrows(OutOfStockException.class, ()-> customerOperationImpl.addToCart(ugoBossStore, customer2, "MacBook pro", 1));
    }

    @Test
    public void productShouldBeRemovedFromTheCart() throws OutOfStockException, StaffNotAuthorizedException, InsufficientFundException {
        customerOperationImpl.addToCart(ugoBossStore, customer, "MacBook pro", 5);
        customer.setWalletBalance(3_000_000);
        adminOperation.sellProduct(ugoBossStore, cashier, customer);
        assertTrue(customer.getCart().isEmpty());
   }



   @Test
   public void testForBuyingQuantityOfProductExceedingStoreQuantity() {
       assertThrows(OutOfStockException.class, () -> customerOperationImpl.addToCart(ugoBossStore, customer, "Tecno", 5));
   }

   @Test
   public void customerProductInCartShouldReduce() throws OutOfStockException, NotTheExactQuantityException {
       customerOperationImpl.addToCart(ugoBossStore, customer, "MacBook pro", 5);
       customerOperationImpl.removeFromCart(customer, "MacBook pro", 2);
       assertEquals(3, (int) customer.getCart().get("MacBook pro"));
   }

   @Test
    public void shouldThrowExceptionWhenQuantityreducedIsMoreThanGoodsInCart() throws OutOfStockException {
       customerOperationImpl.addToCart(ugoBossStore, customer, "MacBook pro", 5);
       assertThrows(NotTheExactQuantityException.class, ()-> customerOperationImpl.removeFromCart(customer, "MacBook pro", 10));
   }

    @Test
    public void customerCanSeeGoodsByCategory() throws StaffNotAuthorizedException {
        assertEquals( 2, customerOperationImpl.viewProductByCategory(ugoBossStore, "Laptops").size());
        assertEquals( "Laptops", customerOperationImpl.viewProductByCategory(ugoBossStore, "Laptops").get(0).getProductCategory());
        assertEquals( "Phones", customerOperationImpl.viewProductByCategory(ugoBossStore, "Phones").get(1).getProductCategory());
    }
}