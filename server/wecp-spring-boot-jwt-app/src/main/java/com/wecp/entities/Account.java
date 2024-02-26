package com.wecp.entities;


 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
 
@Entity
public class Account {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    @ManyToOne
    // @JoinColumn(name = "customerId") // one customer can be mapped to many
    // accounts
    private User customer;
    private String accountType;
    private double balance;
 
 
    public Account() {
    }
 
    public Account(User customer, String accountType, double balance) {
        this.customer = customer;
        this.accountType = accountType;
        this.balance = balance;
    }
 
    public long getAccountId() {
        return accountId;
    }
 
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
 
    public User getCustomer() {
        return customer;
    }
 
    public void setCustomer(User customer) {
        this.customer = customer;
    }
 
    public String getAccountType() {
        return accountType;
    }
 
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
 
    public double getBalance() {
        return balance;
    }
 
    public void setBalance(double balance) {
        this.balance = balance;
    }
}