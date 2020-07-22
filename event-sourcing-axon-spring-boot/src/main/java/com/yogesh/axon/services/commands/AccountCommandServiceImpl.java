/* (C)2020 */
package com.yogesh.axon.services.commands;

import com.yogesh.axon.commands.CreateAccountCommand;
import com.yogesh.axon.commands.CreditMoneyCommand;
import com.yogesh.axon.commands.DebitMoneyCommand;
import com.yogesh.axon.dto.AccountCreateDTO;
import com.yogesh.axon.dto.MoneyCreditDTO;
import com.yogesh.axon.dto.MoneyDebitDTO;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {
    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(
                CreateAccountCommand.builder()
                        .id(UUID.randomUUID().toString())
                        .accountBalance(accountCreateDTO.getStartingBalance())
                        .currency(accountCreateDTO.getCurrency())
                        .build());
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(
            String accountNumber, MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(
                CreditMoneyCommand.builder()
                        .id(accountNumber)
                        .creditAmount(moneyCreditDTO.getCreditAmount())
                        .currency(moneyCreditDTO.getCurrency())
                        .build());
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(
            String accountNumber, MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(
                DebitMoneyCommand.builder()
                        .id(accountNumber)
                        .debitAmount(moneyDebitDTO.getDebitAmount())
                        .currency(moneyDebitDTO.getCurrency())
                        .build());
    }
}
