package model.common;

import model.Customer;

import java.util.Comparator;

public class SortByQuantity implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
      var customer1product=  o1.getCart().entrySet().iterator().next();
      var customer2product=  o2.getCart().entrySet().iterator().next();
      if (customer1product.getKey().equals(customer2product.getKey())){
          return customer1product.getValue() - customer2product.getValue();
      }
      return 0;
    }
}
