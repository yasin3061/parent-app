package org.company.app.service.account.operations;

import org.company.app.service.dataobjects.AccountDto;

public interface AccountOperationsService {

    // look at the method names here. Compare this with the names in persistence layer.
    // here we are all talking business rules.
    void openNewAccount(AccountDto account);
    AccountDto getAccountDetails(Long accountId);
//    Account closeAccount(Long accountId);
}
