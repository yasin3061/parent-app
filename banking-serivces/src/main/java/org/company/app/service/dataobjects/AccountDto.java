package org.company.app.service.dataobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AccountDto {

    private Long id;
    private String holderName;
    private String baseBranch;
}
