/* (C)2020 */
package com.yogesh.axon.controllers;

import com.yogesh.axon.dto.AccountCreateDTO;
import com.yogesh.axon.dto.MoneyCreditDTO;
import com.yogesh.axon.dto.MoneyDebitDTO;
import com.yogesh.axon.services.commands.AccountCommandService;
import io.swagger.annotations.Api;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Commands", tags = "Account Commands")
@RequiredArgsConstructor
public class AccountCommandController {
    private final AccountCommandService accountCommandService;

    @PostMapping
    public CompletableFuture<String> createAccount(@RequestBody AccountCreateDTO accountCreateDTO) {
        return accountCommandService.createAccount(accountCreateDTO);
    }

    @PutMapping(value = "/credits/{accountNumber}")
    public CompletableFuture<String> creditMoneyToAccount(
            @PathVariable(value = "accountNumber") String accountNumber,
            @RequestBody MoneyCreditDTO moneyCreditDTO) {
        return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDTO);
    }

    @PutMapping(value = "/debits/{accountNumber}")
    public CompletableFuture<String> debitMoneyFromAccount(
            @PathVariable(value = "accountNumber") String accountNumber,
            @RequestBody MoneyDebitDTO moneyDebitDTO) {
        return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
    }
}
