/* (C)2020 */
package com.yogesh.axon.aggregates;

import com.yogesh.axon.commands.CreateAccountCommand;
import com.yogesh.axon.commands.CreditMoneyCommand;
import com.yogesh.axon.commands.DebitMoneyCommand;
import com.yogesh.axon.events.*;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@RequiredArgsConstructor
public class AccountAggregate {
    @AggregateIdentifier private String id;

    private double accountBalance;
    private String currency;
    private String status;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand) {
        AggregateLifecycle.apply(
                AccountCreatedEvent.builder()
                        .id(createAccountCommand.getId())
                        .accountBalance(createAccountCommand.getAccountBalance())
                        .currency(createAccountCommand.getCurrency())
                        .build());
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent accountCreatedEvent) {
        this.id = accountCreatedEvent.getId();
        this.accountBalance = accountCreatedEvent.getAccountBalance();
        this.currency = accountCreatedEvent.getCurrency();
        this.status = String.valueOf(Status.CREATED);

        AggregateLifecycle.apply(
                AccountActivatedEvent.builder().id(this.id).status(Status.ACTIVATED).build());
    }

    @EventSourcingHandler
    protected void on(AccountActivatedEvent accountActivatedEvent) {
        this.status = String.valueOf(accountActivatedEvent.getStatus());
    }

    @CommandHandler
    protected void on(CreditMoneyCommand creditMoneyCommand) {
        AggregateLifecycle.apply(
                MoneyCreditedEvent.builder()
                        .id(creditMoneyCommand.getId())
                        .creditAmount(creditMoneyCommand.getCreditAmount())
                        .currency(creditMoneyCommand.getCurrency())
                        .build());
    }

    @EventSourcingHandler
    protected void on(MoneyCreditedEvent moneyCreditedEvent) {

        if (this.accountBalance < 0
                & (this.accountBalance + moneyCreditedEvent.getCreditAmount()) >= 0) {
            AggregateLifecycle.apply(
                    AccountActivatedEvent.builder().id(this.id).status(Status.ACTIVATED).build());
        }

        this.accountBalance += moneyCreditedEvent.getCreditAmount();
    }

    @CommandHandler
    protected void on(DebitMoneyCommand debitMoneyCommand) {
        AggregateLifecycle.apply(
                MoneyDebitedEvent.builder()
                        .debitAmount(debitMoneyCommand.getDebitAmount())
                        .id(debitMoneyCommand.getId())
                        .currency(debitMoneyCommand.getCurrency())
                        .build());
    }

    @EventSourcingHandler
    protected void on(MoneyDebitedEvent moneyDebitedEvent) {

        if (this.accountBalance >= 0
                & (this.accountBalance - moneyDebitedEvent.getDebitAmount()) < 0) {
            AggregateLifecycle.apply(
                    AccountHeldEvent.builder().id(this.id).status(Status.HOLD).build());
        }

        this.accountBalance -= moneyDebitedEvent.getDebitAmount();
    }

    @EventSourcingHandler
    protected void on(AccountHeldEvent accountHeldEvent) {
        this.status = String.valueOf(accountHeldEvent.getStatus());
    }
}
