package operations;

import enums.Designation;
import exceptions.*;
import model.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdminOperationImpl implements AdminOperations{

    @Override
    public void addProductsToStore(Store store, Staff staff) throws StaffNotAuthorizedException{
        if (!staff.getDesignation().equals(Designation.MANAGER)) throw new StaffNotAuthorizedException("You are not authorized to perform this operation");

            try {
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook("src/main/resources/excelFiles/ugo-store.xlsx");
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
                for (int i = 1; i <= xssfSheet.getLastRowNum(); i++) {
                XSSFRow xssfRow = xssfSheet.getRow(i);
                store.getStocks().put(new Product(
                        xssfRow.getCell(1).getStringCellValue(),
                        xssfRow.getCell(2).getStringCellValue(),
                        xssfRow.getCell(3).getNumericCellValue(),
                        (int) xssfRow.getCell(4).getNumericCellValue()));
                }
                } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void sellToCustomersInQueue(Store store, Staff staff) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (Customer customer : store.getCustomersQueue()){
            executorService.execute(()->{
                try {
                    System.out.println("Selling to " + customer.getFirstName() +  " using "
                            + Thread.currentThread().getName());
                    sellProduct(store, staff, customer);
                } catch (OutOfStockException | InsufficientFundException  | StaffNotAuthorizedException e) {
                    e.printStackTrace();
                } finally {
                    store.getCustomersQueue().clear();
                }
            });
        }
        executorService.shutdown();
    }

    @Override
    public void sellProduct (Store store, Staff staff, Customer customer) throws StaffNotAuthorizedException, InsufficientFundException, OutOfStockException {
        var customerProduct = customer.getCart().entrySet().iterator().next();
        if (customerProduct.getValue() > store.getStocks().get(customerProduct.getKey()).getQuantity()) throw new OutOfStockException("Company does not have up to required product!");
        if (!staff.getDesignation().equals(Designation.CASHIER)) throw new StaffNotAuthorizedException("Only cashier can sell product");
        double totalPrice = 0.00;

        for (var products :  customer.getCart().entrySet()){
            double productPrice = store.getStocks().get(products.getKey()).getPrice();
            totalPrice += productPrice * products.getValue();
        }
        if (customer.getWalletBalance() < totalPrice) throw new InsufficientFundException("Insufficient fund");

        for (var products : customer.getCart().entrySet()){
          Product product =  store.getStocks().get(products.getKey());
          product.setQuantity(product.getQuantity() - products.getValue());

        }
        customer.getCart().clear();
        removeCustomerFromQueue(store, customer);
    }

    private  void removeCustomerFromQueue(Store store, Customer customer){
        store.getCustomersQueue().remove(customer);
    }
}
