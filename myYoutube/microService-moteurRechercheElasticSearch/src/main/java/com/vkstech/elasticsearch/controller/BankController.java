package com.vkstech.elasticsearch.controller;

import com.vkstech.elasticsearch.entity.Bank;
import com.vkstech.elasticsearch.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bank")
public class BankController {

    private final BankRepository bankRepository;

    @Autowired
    public BankController(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @PostMapping("save")
    public Bank saveBank(@RequestBody Bank bank) {
        return bankRepository.save(bank);
    }

    @GetMapping("findAll")
    public Iterable<Bank> findAllBanks() {
        return bankRepository.findAll();
    }

    @GetMapping("findByName/{name}")
    public List<Bank> findByName(@PathVariable String name) {
        return bankRepository.findByName(name);
    }

}
