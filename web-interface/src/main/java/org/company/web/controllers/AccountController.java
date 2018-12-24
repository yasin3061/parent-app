package org.company.web.controllers;

import org.company.app.service.account.operations.AccountOperationsService;
import org.company.web.account.response.AccountResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private final AccountOperationsService service;

    public AccountController(AccountOperationsService service) {
        this.service = service;
    }

    @GetMapping
    public List<AccountResponse> getAllAccounts() {
        return service.getAllAccountDetails().stream().map(a -> AccountResponse.builder().baseBranch(a.getBaseBranch
                ()).holderName(a.getHolderName()).id(a.getId()).build()).collect(Collectors.toList());
    }
}
