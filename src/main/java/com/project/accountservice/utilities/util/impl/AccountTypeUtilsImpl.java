package com.project.accountservice.utilities.util.impl;

import com.project.accountservice.models.dto.AccountType;
import com.project.accountservice.models.response.AccountTypeFindBalancesResponse;
import com.project.accountservice.utilities.util.IAccountTypeUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeUtilsImpl implements IAccountTypeUtils {
    @Override
    public AccountType accountTypeFindBalancesResponseDTOToAccountType(AccountTypeFindBalancesResponse accountTypeDTO) {
        return AccountType.builder()
                .description(accountTypeDTO.getDescription())
                .build();
    }

    @Override
    public AccountTypeFindBalancesResponse accountTypeToAccountTypeFindBalancesResponseDTO(AccountType accountType) {
        return AccountTypeFindBalancesResponse.builder()
                .description(accountType.getDescription())
                .build();
    }
}
