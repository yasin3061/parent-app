package org.company.app.service.persistence;

import org.company.app.service.dataobjects.AccountDto;
import org.company.app.service.exceptions.AccountNotFoundException;

public interface AccountPersistenceGateway {

    void saveAccount(AccountDto account);

    AccountDto findAccountById(Long accountId) throws AccountNotFoundException;

    // not yet implemented
//    Account softDeleteAccount(Long accountId);
}
