package org.company.web.spring.config;

import org.company.app.service.account.operations.AccountOperationsService;
import org.company.app.service.account.operations.impl.AccountOperationsServiceImpl;
import org.company.app.service.persistence.AccountPersistenceGateway;
import org.company.persistence.connectors.AccountPersistenceGatewayConnector;
import org.company.persistence.repository.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebAppBeansConfig {

    @Bean
    public AccountPersistenceGateway getAccountPersistenceGateway(AccountRepository repository) {
        return new AccountPersistenceGatewayConnector(repository);
    }

    @Bean
    public AccountOperationsService getAccountOperationsService(AccountPersistenceGateway gateway) {
        return new AccountOperationsServiceImpl(gateway);
    }
}
