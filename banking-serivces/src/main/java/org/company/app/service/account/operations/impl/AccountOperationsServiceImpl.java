package org.company.app.service.account.operations.impl;

import org.company.app.service.account.operations.AccountOperationsService;
import org.company.app.service.dataobjects.AccountDto;
import org.company.app.service.persistence.AccountPersistenceGateway;

import java.util.List;

public class AccountOperationsServiceImpl implements AccountOperationsService{

    private AccountPersistenceGateway persistence;

    public AccountOperationsServiceImpl(AccountPersistenceGateway persistence) {
        this.persistence = persistence;
    }


    @Override
    public AccountDto openNewAccount(AccountDto account) {
        return persistence.saveAccount(account);
    }

    @Override
    public AccountDto getAccountDetails(Long accountId) {
        return persistence.findAccountById(accountId);
    }

    @Override
    public List<AccountDto> getAllAccountDetails() {
        return persistence.findAll();
    }

//    @Override
//    public Account closeAccount(Long accountId) {
//        return persistence.softDeleteAccount(accountId);
//    }
}
