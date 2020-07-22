/* (C)2020 */
package com.yogesh.axon.services.commands;

import com.yogesh.axon.dto.AccountCreateDTO;
import com.yogesh.axon.dto.MoneyCreditDTO;
import com.yogesh.axon.dto.MoneyDebitDTO;
import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {
    CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);

    CompletableFuture<String> creditMoneyToAccount(
            String accountNumber, MoneyCreditDTO moneyCreditDTO);

    CompletableFuture<String> debitMoneyFromAccount(
            String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
