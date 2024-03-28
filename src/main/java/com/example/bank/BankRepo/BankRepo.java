package com.example.bank.BankRepo;

import com.example.bank.BankModel.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<BankModel, Long>{}
