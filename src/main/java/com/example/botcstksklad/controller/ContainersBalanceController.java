package com.example.botcstksklad.controller;

import com.example.botcstksklad.model.Balance;
import com.example.botcstksklad.model.ContainerBalance;
import com.example.botcstksklad.service.ContainersBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("containers-balance")
public class ContainersBalanceController {

    public ContainersBalanceService containersBalanceService = new ContainersBalanceService();

    @PostMapping
    public void updateContainerBalance(@RequestBody String body) {
        containersBalanceService.updateContainersBalance(body);
    }

    @GetMapping
    public List<ContainerBalance> getContainerBalance() {
        return Balance.containerBalanceList;
    }
}
