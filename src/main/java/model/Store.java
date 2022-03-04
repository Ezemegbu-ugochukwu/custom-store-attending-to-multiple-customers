package model;

import customerqueue.CustomerQueue;
import model.common.SortByQuantity;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Store {
    private final String name;
    private final List<Staff> ListOfStaffs = new ArrayList<>();
    private final List<Applicant> applicants = new ArrayList<>();
    private final Stocks stocks = new Stocks();
    private final CustomerQueue customersQueue = new CustomerQueue();

    public Store (String name){
        this.name = name;
    }

    public CustomerQueue getCustomersQueue() {return customersQueue;}

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
