package org.company.web.controllers;

import org.company.app.service.account.operations.AccountOperationsService;
import org.company.app.service.dataobjects.AccountDto;
import org.company.web.account.request.AccountRequest;
import org.company.web.account.response.AccountResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
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
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        List<AccountResponse> accounts = service.getAllAccountDetails().stream().map(a -> AccountResponse.builder()
                .baseBranch(a.getBaseBranch
                ()).holderName(a.getHolderName()).id(a.getId()).build()).collect(Collectors.toList());
        return ResponseEntity.ok().body(accounts);
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody AccountRequest request) {
        AccountDto newAccount = service.openNewAccount(AccountDto.builder().baseBranch(request.getBaseBranch())
                .holderName(request.getHolderName()).build());
        return ResponseEntity.created(URI.create("/accounts/" + newAccount.getId())).build();
    }
}
