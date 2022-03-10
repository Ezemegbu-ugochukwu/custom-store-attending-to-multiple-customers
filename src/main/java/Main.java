import enums.Designation;
import enums.Gender;
import enums.Qualification;
import exceptions.*;
import model.*;
import operations.AdminOperationImpl;
import operations.CustomerOperationImpl;
import recruitment.RecruitmentImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InsufficientFundException, OutOfStockException, ApplicantAlreadyAppliedException, NotTheExactQuantityException, CustomerNotCheckedOutException, NotQualifiedException, StaffNotAuthorizedException, IOException, CannotJoinQueueTwice, InterruptedException {
         AdminOperationImpl adminOperation = new AdminOperationImpl();
        CustomerOperationImpl customerOperation = new CustomerOperationImpl();
        RecruitmentImpl recruitment = new RecruitmentImpl();

        Applicant charles = new Applicant("charles","john","106PARK",Gender.MALE, Qualification.BSC);

        Store hugoBoss = new Store("hugoBoss");
        Staff manager = new Staff("John", "Boss", Gender.MALE, Designation.MANAGER);
        Staff cashier = new Staff("John", "Boy", Gender.MALE, Designation.CASHIER);
        Customer ugo = new Customer("Ugonna", "Chukwu", Gender.MALE, 80000000);
        Customer love = new Customer("love", "Chukwu", Gender.MALE, 80000000);
        Customer moses = new Customer("moses", "Chukwu", Gender.MALE, 80000000);
        Customer ben = new Customer("ben", "Chukwu", Gender.MALE, 80000000);
        Customer david = new Customer("david", "Chukwu", Gender.MALE, 80000000);

        adminOperation.addProductsToStore(hugoBoss, manager);
//        System.out.println(ugoBossStore.getStocks());
        customerOperation.addToCart(hugoBoss,love,"MacBook pro",10);  //3
        customerOperation.addToCart(hugoBoss,ben,"Iphone",5);//5
        customerOperation.addToCart(hugoBoss,ugo,"MacBook pro",7);  //2
        customerOperation.addToCart(hugoBoss,moses,"Hp EliteBook",15);  //1
        customerOperation.addToCart(hugoBoss,david,"Tecno Camera",1); //4

        customerOperation.joinQueue(hugoBoss,moses); //1
        customerOperation.joinQueue(hugoBoss,love); //3
        customerOperation.joinQueue(hugoBoss,david); //4
        customerOperation.joinQueue(hugoBoss,ugo);// 2
        customerOperation.joinQueue(hugoBoss,ben);//5

//        long start = System.currentTimeMillis();
//        for (Customer customer : hugoBoss.getCustomersQueue()){
//            adminOperation.sellProduct(hugoBoss, cashier, customer);
//        }
//        System.out.println(System.currentTimeMillis() - start);

        System.out.println("MacBook before sale : " + hugoBoss.getStocks().get("MacBook pro"));
        System.out.println(hugoBoss.getStocks());
        adminOperation.sellToCustomersInQueue(hugoBoss, cashier);
//        Thread.sleep(1500);
        System.out.println(hugoBoss.getStocks());
        //System.out.println("MacBook after sale : " + hugoBoss.getStocks().get("MacBook pro"));



//        adminOperation.addProductsToStore(hugoBoss, manager);
//        adminOperation.sellToCustomersInQueue(hugoBoss,cashier);




//        System.out.println(hugoBoss.getStocks());






    //    adminOperation.viewProductByCategory(hugoBoss, "Laptops");
//        customerOperation.addToCart(hugoBoss, ugo, "MacBook pro", 20);
//        customerOperation.addToCart(hugoBoss, ugo, "Iphone", 3);
//        customerOperation.addToCart(hugoBoss, love, "MacBook pro", 1);
//        customerOperation.addToCart(hugoBoss, moses, "MacBook pro", 7);
//        customerOperation.addToCart(hugoBoss, ben, "Tecno ", 3);
//
//        customerOperation.joinQueue(hugoBoss,ben);
//        customerOperation.joinQueue(hugoBoss,love);
//        customerOperation.joinQueue(hugoBoss,ugo);
//        customerOperation.joinQueue(hugoBoss,moses);

//        while (hugoBoss.getCustomersQueue().hasNext()){
//            System.out.println(hugoBoss.getCustomersQueue().poll());
//        }




//        customerOperation.addToCart(hugoBoss, ugo, "Tecno ", 1);
//        System.out.println(ugo.getCart());
//        adminOperation.sellProduct(hugoBoss,cashier,ugo);

//        System.out.println(ugo);

//        customerOperation.addToCart(hugoBoss,ugo,"Tecno ", 1);

//        System.out.println(ugo.getCart());

  //      adminOperation.sellProduct(hugoBoss, cashier, ugo);

 //       System.out.println(ugo.getCart());
//        System.out.println(hugoBoss.getStocks());

//        adminOperations.addProductsToStore(hugoBoss, manager, "src/main/resources/excelFiles/hugo_store.xlsx");
//        System.out.println(Arrays.toString(hugoBoss.getStocks()));
//        System.out.println(hugoBoss.getStocks());
//
//        for (int i = 0; i < hugoBoss.getStocks().size(); i++){
//            System.out.println(hugoBoss.getStocks().get(i));
//        }
  //      applicationImpl.apply(charles,hugoBoss);   //apply to store
  //      System.out.println(hugoBoss.getApplicants());

//        hugoBoss.getListOfStaffs().put(john);    //manager hiring cashier
   //     recruitmentImpl.singleHire(charles,john,hugoBoss);
  //      System.out.println(hugoBoss.getListOfStaffs());
//
//        hugoBoss.getStocks().put(SamsungInfinix,10);
//        customerOperations.addToCart(hugoBoss, ugo,macBookPro,5); //put to cart
//
//        customerOperations.removeFromCart(ugo,macBookPro , 3); // remove from cart
//        System.out.println("ugo's cart "+ugo.getCart());

//
//        customerOperations.buyProduct(ugo);    //buy product
//        adminOperations.sellProduct(cashier,ugo);




//
//
//




//        hugoBoss.getStocks();
//        System.out.println(hugoBoss.getStocks());
//        System.out.println(hugoBoss.getListOfStaffs());
//

    }
}
