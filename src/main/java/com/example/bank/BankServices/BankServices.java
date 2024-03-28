package com.example.bank.BankServices;

import com.example.bank.BankModel.BankModel;
import com.example.bank.BankRepo.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BankServices {
    @Autowired
    BankRepo acc;

    public void add(BankModel account){
        account.setAcnumber(generateacnumber());
        acc.save(account);
    }

    public long generateacnumber() {
        long acnumber = 0;
        Random r1 =new Random();
        for(int i = 0; i<10; i++){
            int d =r1.nextInt(10);
            acnumber=acnumber*10+d;
        }
        return acnumber;
    }

    public List<BankModel> getall(){
        return acc.findAll();
    }

    public String withdraw(long num, double amount){
        BankModel accDe;
        try {
            accDe = acc.findById(num).get();
        }catch (Exception ex){
            return "Account Not Available.";
        }
        double balance = accDe.getBalance();
        if(amount>balance){
            return "Not Sufficient Balance.";
        }
        double remainBalance = balance - amount;
        accDe.setBalance(remainBalance);
        acc.save(accDe);
        return "Successfully Withdraw." + remainBalance;
    }

    public String deposite(long num, double amount) {
        BankModel accDe;

        try{
            accDe = acc.findById(num).get();
        }catch (Exception ex){
            return "Account Is Not Available.";
        }

        double balance = accDe.getBalance();
        balance = balance + amount;
        accDe.setBalance(balance);
        acc.save(accDe);

        return "Successfully Deposite" + balance;
    }

    public String transfer(long num1, long num2, double amount) {
        BankModel b1;
        BankModel b2;
        try {
            b1 = acc.findById(num1).get();
            b2 = acc.findById(num2).get();
        } catch (Exception ex){
            return "Ac Not Found";
        }
        if(b1.getBalance()<amount){
            return "Please Check Account Balance.";
        }
        b1.setBalance(b1.getBalance() - amount);
        b2.setBalance(b2.getBalance() + amount);
        acc.save(b1);
        acc.save(b2);
        return b1.getName() + "transfer" + amount + "to" + b2.getName();
    }

    public String balance(long num) {
        BankModel b1;
        try{
            b1 = acc.findById(num).get();
        }catch (Exception ex){
            return "Ac Not Found.";
        }
        return "Account Balance Is : " + b1.getBalance();
    }
}
