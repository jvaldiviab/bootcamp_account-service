package com.project.accountservice.utilities.util;

import com.project.accountservice.models.dto.Client;
import com.project.accountservice.models.entity.AccountEntity;
import com.project.accountservice.models.request.AccountCreateRequest;
import com.project.accountservice.models.request.AccountUpdateRequest;
import com.project.accountservice.models.response.AccountFindBalancesResponse;

public interface IAccountUtils {
    AccountEntity accountCreateRequestToAccount(AccountCreateRequest account, Client client);
    AccountEntity accountUpdateRequestDTOToAccount(AccountUpdateRequest accountDTO);
    AccountEntity accountFindBalancesResponseDTOToAccount(AccountFindBalancesResponse accountDTO);
    AccountCreateRequest accountToAccountCreateRequestDTO(AccountEntity account);
    AccountUpdateRequest accountToAccountUpdateRequestDTO(AccountEntity account);
    AccountFindBalancesResponse accountToAccountFindBalancesResponse(AccountEntity account);
    AccountEntity fillAccountWithAccountUpdateRequestDTO(AccountEntity account, AccountUpdateRequest accountDTO);
}
