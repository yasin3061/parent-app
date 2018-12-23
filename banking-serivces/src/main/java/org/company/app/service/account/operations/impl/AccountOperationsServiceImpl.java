package org.company.app.service.account.operations.impl;

import org.company.app.service.account.operations.AccountOperationsService;
import org.company.app.service.dataobjects.Account;
import org.company.app.service.persistence.AccountPersistenceGateway;

public class AccountOperationsServiceImpl implements AccountOperationsService{

    private AccountPersistenceGateway persistence;

    public AccountOperationsServiceImpl(AccountPersistenceGateway persistence) {
        this.persistence = persistence;
    }


    @Override
    public void openNewAccount(Account account) {
        persistence.saveAccount(account);
    }

    @Override
    public Account getAccountDetails(Long accountId) {
        return persistence.findAccountById(accountId);
    }

//    @Override
//    public Account closeAccount(Long accountId) {
//        return persistence.softDeleteAccount(accountId);
//    }
}
