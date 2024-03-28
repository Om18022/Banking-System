package com.example.bank.BankModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class BankModel {
    @Id
    public long acnumber;
    public String name;
    public double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAcnumber() {
        return acnumber;
    }

    public void setAcnumber(long acnumber) {
        this.acnumber = acnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
