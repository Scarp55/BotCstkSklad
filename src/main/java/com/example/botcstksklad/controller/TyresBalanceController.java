package com.example.botcstksklad.controller;

import com.example.botcstksklad.model.Balance;
import com.example.botcstksklad.model.TyresBalance;
import com.example.botcstksklad.service.TyresBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("cells-balance")
public class TyresBalanceController {


    public TyresBalanceService tyresBalanceService = new TyresBalanceService();

    @PostMapping
    public void updateTyresBalance(@RequestBody String body) {
        tyresBalanceService.updateTyresBalance(body);
    }

    @GetMapping
    public List<TyresBalance> getTyresBalance() {
        return Balance.tyresBalanceList;
    }
}
