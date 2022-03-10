package model;

import customerqueue.CustomerQueue;
import model.common.SortByQuantity;

import java.util.*;

public class Store {
    private final String name;
    private final List<Staff> ListOfStaffs = new ArrayList<>();
    private final List<Applicant> applicants = new ArrayList<>();
    private final Stocks stocks = new Stocks();
   // private final CustomerQueue customersQueue = new CustomerQueue();
    private final List<Customer> customersQueue = new Vector<>();

    public Store (String name){
        this.name = name;
    }

    public List<Customer> getCustomersQueue() {return customersQueue;}

    public List<Staff> getListOfStaffs() {
        return ListOfStaffs;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public Stocks getStocks (){ return stocks;}


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", ListOfStaffs=" + ListOfStaffs +
                ", applicants=" + applicants +
                '}';
    }
}
