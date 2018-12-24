package org.company.persistence.connectors;

import org.company.app.service.dataobjects.AccountDto;
import org.company.app.service.exceptions.AccountNotFoundException;
import org.company.app.service.persistence.AccountPersistenceGateway;
import org.company.persistence.model.Account;
import org.company.persistence.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountPersistenceGatewayConnector implements AccountPersistenceGateway {

    private AccountRepository repository;

    public AccountPersistenceGatewayConnector(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAccount(AccountDto account) {
        Account toBeSaved = Account.builder().holderName(account.getHolderName()).baseBranch(account.getBaseBranch())
                .build();
        repository.save(toBeSaved);
    }

    @Override
    public AccountDto findAccountById(Long accountId) {
        Optional<Account> fromDb = repository.findAccountById(accountId);
        if (fromDb.isPresent()) {
            Account found = fromDb.get();
            return AccountDto.builder().id(found.getId()).holderName(found.getHolderName())
                    .baseBranch(found.getBaseBranch()).build();
        } else {
            throw new AccountNotFoundException("The account with ID " + accountId + " was not found.");
        }
    }

    @Override
    public List<AccountDto> findAll() {
        List<Account> allAccountsFromDb = repository.findAll();
        List<AccountDto> allAccounts = new ArrayList<>();
        allAccounts = allAccountsFromDb.stream().map(a -> AccountDto.builder().baseBranch(a.getBaseBranch())
                .holderName(a.getHolderName()).id(a.getId()).build()).collect(Collectors.toList());
        return allAccounts;
    }
}
