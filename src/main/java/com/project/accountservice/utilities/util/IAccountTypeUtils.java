package com.project.accountservice.utilities.util;

import com.project.accountservice.models.dto.AccountType;
import com.project.accountservice.models.response.AccountTypeFindBalancesResponse;

public interface IAccountTypeUtils {
    AccountType accountTypeFindBalancesResponseDTOToAccountType(AccountTypeFindBalancesResponse accountTypeDTO);
    AccountTypeFindBalancesResponse accountTypeToAccountTypeFindBalancesResponseDTO(AccountType accountType);
}
