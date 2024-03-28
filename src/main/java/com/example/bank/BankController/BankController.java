package com.example.bank.BankController;

import com.example.bank.BankModel.BankModel;
import com.example.bank.BankServices.BankServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {
    @Autowired
    BankServices b1 = new BankServices();

    @PostMapping("/add")
    public BankModel acc(@RequestBody BankModel a1){
    b1.add(a1);
    return a1;
    }

    @GetMapping("/getall")
    public List<BankModel> getall(){
        return b1.getall();
    }

    @PutMapping("/withdraw")
    public @ResponseBody String withdraw(@RequestParam long num,@RequestParam double amount){
    return b1.withdraw(num,amount);
    }

    @PutMapping("deposite")
    public @ResponseBody String deposite(@RequestParam long num, double amount){
        return b1.deposite(num, amount);
    }

    @PutMapping("transfer")
    public String transfer(@RequestParam long num1, long num2, double amount){
        return b1.transfer(num1,num2,amount);
    }

    @GetMapping("balance")
    public String  balance(@RequestParam long num){
        return b1.balance(num);
    }
}
