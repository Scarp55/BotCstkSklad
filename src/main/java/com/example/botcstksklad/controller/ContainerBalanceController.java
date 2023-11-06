package com.example.botcstksklad.controller;

import com.example.botcstksklad.model.ContainerBalance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("container-balance")
public class ContainerBalanceController {

    public static ContainerBalance containerBalance = new ContainerBalance();

    @PostMapping
    public void updateContainerBalance(@RequestBody String body) {
        containerBalance.setContainerBalance(body);
    }

    @GetMapping
    public String getContainerBalance() {
        return containerBalance.getContainerBalance();
    }
}
