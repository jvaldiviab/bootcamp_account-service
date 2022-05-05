package com.project.accountservice.utilities.util.impl;

import com.project.accountservice.models.dto.AccountSpecifications;
import com.project.accountservice.models.dto.Client;
import com.project.accountservice.models.entity.AccountEntity;
import com.project.accountservice.models.request.AccountCreateRequest;
import com.project.accountservice.models.request.AccountUpdateRequest;
import com.project.accountservice.models.response.AccountFindBalancesResponse;
import com.project.accountservice.utilities.constants.Constants;
import com.project.accountservice.utilities.util.IAccountTypeUtils;
import com.project.accountservice.utilities.util.IAccountUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccountUtilsImpl implements IAccountUtils {
    private IAccountTypeUtils accountTypeUtils;
    private final Constants constants;

    public AccountEntity accountCreateRequestToAccount(AccountCreateRequest account, Client client){

        if(client.getClientType().getDescription().contentEquals(constants.getClientPersonal()) &&
        client.getClientType().getType().contentEquals(constants.getClientPersonalNormal()) &&
        account.getAccountType().getDescription().contentEquals(constants.getAccountSavings())) {
            account.setAccountSpecifications(AccountSpecifications.builder()
                    .maintenanceCommission(Double.parseDouble(constants.getPassivePersonalNormalSavingMaintenanceCommission()))
                    .minimumDailyAverage(Double.parseDouble(constants.getPassivePersonalNormalSavingMinimumDailyAverage()))
                    .transactionCommission(Double.parseDouble(constants.getPassivePersonalNormalSavingTransactionCommission()))
                    .maximumNumberOfTransaction(Integer.parseInt(constants.getPassivePersonalNormalSavingMaximumNumberTransaction()))
                    .allowedDayForTransaction(Integer.parseInt(constants.getPassivePersonalNormalSavingAllowedDayTransaction()))
                    .build());
        } else if (client.getClientType().getDescription().contentEquals(constants.getClientPersonal()) &&
                client.getClientType().getType().contentEquals(constants.getClientPersonalVip()) &&
                account.getAccountType().getDescription().contentEquals(constants.getAccountSavings())) {
            account.setAccountSpecifications(AccountSpecifications.builder()
                    .maintenanceCommission(Double.parseDouble(constants.getPassivePersonalVipSavingMaintenanceCommission()))
                    .minimumDailyAverage(Double.parseDouble(constants.getPassivePersonalVipSavingMinimumDailyAverage()))
                    .transactionCommission(Double.parseDouble(constants.getPassivePersonalVipSavingTransactionCommission()))
                    .maximumNumberOfTransaction(Integer.parseInt(constants.getPassivePersonalVipSavingMaximumNumberTransaction()))
                    .allowedDayForTransaction(Integer.parseInt(constants.getPassivePersonalVipSavingAllowedDayTransaction()))
                    .build());
        } else if (client.getClientType().getDescription().contentEquals(constants.getClientPersonal()) &&
                account.getAccountType().getDescription().contentEquals(constants.getAccountCurrent())) {
            account.setAccountSpecifications(AccountSpecifications.builder()
                    .maintenanceCommission(Double.parseDouble(constants.getPassivePersonalNormalCurrentMaintenanceCommission()))
                    .minimumDailyAverage(Double.parseDouble(constants.getPassivePersonalNormalCurrentMinimumDailyAverage()))
                    .transactionCommission(Double.parseDouble(constants.getPassivePersonalNormalCurrentTransactionCommission()))
                    .maximumNumberOfTransaction(Integer.parseInt(constants.getPassivePersonalNormalCurrentMaximumNumberTransaction()))
                    .allowedDayForTransaction(Integer.parseInt(constants.getPassivePersonalNormalCurrentAllowedDayTransaction()))
                    .build());
        } else if (client.getClientType().getDescription().contentEquals(constants.getClientPersonal()) &&
                account.getAccountType().getDescription().contentEquals(constants.getAccountLongTerm())) {
            account.setAccountSpecifications(AccountSpecifications.builder()
                    .maintenanceCommission(Double.parseDouble(constants.getPassivePersonalNormalLongTermMaintenanceCommission()))
                    .minimumDailyAverage(Double.parseDouble(constants.getPassivePersonalNormalLongTermMinimumDailyAverage()))
                    .transactionCommission(Double.parseDouble(constants.getPassivePersonalNormalLongTermTransactionCommission()))
                    .maximumNumberOfTransaction(Integer.parseInt(constants.getPassivePersonalNormalLongTermMaximumNumberTransaction()))
                    .allowedDayForTransaction(Integer.parseInt(constants.getPassivePersonalNormalLongTermAllowedDayTransaction()))
                    .build());
        } else if (client.getClientType().getDescription().contentEquals(constants.getClientEnterprise()) &&
                client.getClientType().getType().contentEquals(constants.getClientEnterpriseNormal())) {
            account.setAccountSpecifications(AccountSpecifications.builder()
                    .maintenanceCommission(Double.parseDouble(constants.getPassiveEnterpriseNormalCurrentMaintenanceCommission()))
                    .minimumDailyAverage(Double.parseDouble(constants.getPassiveEnterpriseNormalCurrentMinimumDailyAverage()))
                    .transactionCommission(Double.parseDouble(constants.getPassiveEnterpriseNormalCurrentTransactionCommission()))
                    .maximumNumberOfTransaction(Integer.parseInt(constants.getPassiveEnterpriseNormalCurrentMaximumNumberTransaction()))
                    .allowedDayForTransaction(Integer.parseInt(constants.getPassiveEnterpriseNormalCurrentAllowedDayTransaction()))
                    .build());
        } else if (client.getClientType().getDescription().contentEquals(constants.getClientEnterprise()) &&
                client.getClientType().getType().contentEquals(constants.getClientEnterprisePyme())) {
            account.setAccountSpecifications(AccountSpecifications.builder()
                    .maintenanceCommission(Double.parseDouble(constants.getPassiveEnterpriseVipCurrentMaintenanceCommission()))
                    .minimumDailyAverage(Double.parseDouble(constants.getPassiveEnterpriseVipCurrentMinimumDailyAverage()))
                    .transactionCommission(Double.parseDouble(constants.getPassiveEnterpriseVipCurrentTransactionCommission()))
                    .maximumNumberOfTransaction(Integer.parseInt(constants.getPassiveEnterpriseVipCurrentMaximumNumberTransaction()))
                    .allowedDayForTransaction(Integer.parseInt(constants.getPassiveEnterpriseVipCurrentAllowedDayTransaction()))
                    .build());
        }

        return AccountEntity.builder()
                .status(constants.getStatusActive())
                .client(client)
                .accountType(account.getAccountType())
                .accountSpecifications(account.getAccountSpecifications())
                .accountNumber(UUID.randomUUID().toString())
                .creationDate(new Date(System.currentTimeMillis()))
                .updateDate(new Date(System.currentTimeMillis()))
                .currentBalance(Double.parseDouble(constants.getPassiveInitCurrentBalance()))
                .freeTransactionPerMonth(Integer.valueOf(constants.getTransactionFreeAnyAccount()))
                .build();
    }

    public AccountEntity accountUpdateRequestDTOToAccount(AccountUpdateRequest accountDTO){
        return AccountEntity.builder()
                .id(accountDTO.getId())
                .status(accountDTO.getStatus())
                .updateDate(accountDTO.getUpdateDate())
                .currentBalance(accountDTO.getCurrentBalance())
                .freeTransactionPerMonth(accountDTO.getFreeTransactionPerMonth())
                .build();
    }


    @Override
    public AccountEntity accountFindBalancesResponseDTOToAccount(AccountFindBalancesResponse accountDTO) {
        return AccountEntity.builder()
                .id(accountDTO.getAccountId())
                .currentBalance(accountDTO.getCurrentBalance())
                .accountType(accountTypeUtils.accountTypeFindBalancesResponseDTOToAccountType(accountDTO.getAccountType()))
                .build();
    }

    @Override
    public AccountCreateRequest accountToAccountCreateRequestDTO(AccountEntity account) {
        return AccountCreateRequest.builder()
                .clientId(account.getClient().getId())
                .accountType(account.getAccountType())
                .accountSpecifications(account.getAccountSpecifications())
                .build();
    }

    @Override
    public AccountUpdateRequest accountToAccountUpdateRequestDTO(AccountEntity account) {
        return AccountUpdateRequest.builder()
                .id(account.getId())
                .updateDate(account.getUpdateDate())
                .currentBalance(account.getCurrentBalance())
                .freeTransactionPerMonth(account.getFreeTransactionPerMonth())
                .build();
    }


    @Override
    public AccountFindBalancesResponse accountToAccountFindBalancesResponse(AccountEntity account) {
        return AccountFindBalancesResponse.builder()
                .accountId(account.getId())
                .currentBalance(account.getCurrentBalance())
                .accountType(accountTypeUtils.accountTypeToAccountTypeFindBalancesResponseDTO(account.getAccountType()))
                .build();
    }

    @Override
    public AccountEntity fillAccountWithAccountUpdateRequestDTO(AccountEntity account, AccountUpdateRequest accountDTO) {
        account.setId(accountDTO.getId());
        account.setStatus(accountDTO.getStatus());
        account.setUpdateDate(accountDTO.getUpdateDate());
        account.setCurrentBalance(accountDTO.getCurrentBalance());
        account.setFreeTransactionPerMonth(accountDTO.getFreeTransactionPerMonth());
        return account;
    }
}