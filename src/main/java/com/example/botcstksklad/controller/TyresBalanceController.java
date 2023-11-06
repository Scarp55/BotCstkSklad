package com.example.botcstksklad.controller;

import com.example.botcstksklad.model.TyresBalance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("tyres-balance")
public class TyresBalanceController {

    public static TyresBalance tyresBalance = new TyresBalance();

    @PostMapping
    public void updateTyresBalance(@RequestBody String body) {
        tyresBalance.setTyresBalance(body);
    }

    @GetMapping
    public String getTyresBalance() {
        return tyresBalance.getTyresBalance();
    }
}
