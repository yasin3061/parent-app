package org.company.web.account.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AccountResponse {

    private Long id;
    private String holderName;
    private String baseBranch;

}
