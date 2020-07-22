/* (C)2020 */
package com.yogesh.axon.controllers;

import com.yogesh.axon.services.queries.AccountQueryService;
import io.swagger.annotations.Api;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Queries", tags = "Account Queries")
@RequiredArgsConstructor
public class AccountQueryController {
    private final AccountQueryService accountQueryService;

    @GetMapping("/{accountNumber}/events")
    public List<Object> listEventsForAccount(
            @PathVariable(value = "accountNumber") String accountNumber) {
        return accountQueryService.listEventsForAccount(accountNumber);
    }
}
