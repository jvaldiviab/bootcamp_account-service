package com.project.accountservice.utilities.constants;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Constants {
    // ## status
    @Value("${constants.status.blocked}")
    private String statusBlocked;
    @Value("${constants.status.active}")
    private String statusActive;

    // ## savings-account
    @Value("${constants.account.savings.description}")
    private String accountSavings;
    @Value("${constants.account.savings.type.normal}")
    private String accountSavingsNormal;
    @Value("${constants.account.savings.type.vip}")
    private String accountSavingsVip;

    // ## current-account
    @Value("${constants.account.current.description}")
    private String accountCurrent;
    @Value("${constants.account.current.type.normal}")
    private String accountCurrentNormal;
    @Value("${constants.account.current.type.pyme}")
    private String accountCurrentPyme;

    // ## long-term-account
    @Value("${constants.account.long-term.description}")
    private String accountLongTerm;
    @Value("${constants.account.long-term.type.normal}")
    private String accountLongTermNormal;

    // ## transactions available
    @Value("${constants.transaction.free.any-account}")
    private String transactionFreeAnyAccount;
    @Value("${constants.transaction.free.long-term-day}")
    private String transactionFreeLongTermDay;
    @Value("${constants.transaction.type.deposit}")
    private String transactionDeposit;
    @Value("${constants.transaction.type.withdrawal}")
    private String transactionWithdrawal;
    @Value("${constants.transaction.type.transfer-in}")
    private String transactionTransferIn;
    @Value("${constants.transaction.type.transfer-out}")
    private String transactionTransferOut;

    // ## client personal
    @Value("${constants.client.personal.description}")
    private String clientPersonal;
    @Value("${constants.client.personal.type.normal}")
    private String clientPersonalNormal;
    @Value("${constants.client.personal.type.vip}")
    private String clientPersonalVip;

    // ## client enterprise
    @Value("${constants.client.enterprise.description}")
    private String clientEnterprise;
    @Value("${constants.client.enterprise.type.normal}")
    private String clientEnterpriseNormal;
    @Value("${constants.client.enterprise.type.pyme}")
    private String clientEnterprisePyme;

    // ## service addresses
    @Value("${constants.services.prefix}")
    private String servicesPrefix;
    @Value("${constants.services.url.gateway}")
    private String servicesUrlGateway;
    @Value("${constants.services.url.client}")
    private String servicesUrlClient;
    @Value("${constants.services.url.passive}")
    private String servicesUrlPassive;
    @Value("${constants.services.url.active}")
    private String servicesUrlActive;
    @Value("${constants.services.path.client}")
    private String servicesPathClient;
    @Value("${constants.services.path.passive}")
    private String servicesPathPassive;
    @Value("${constants.services.path.active}")
    private String servicesPathActive;
    @Value("${constants.services.path.credit-card}")
    private String servicesPathCreditCard;

    @Value("${constants.passive.init.current-balance}")
    private String passiveInitCurrentBalance;

    @Value("${constants.passive.account.personal.normal.savings.maintenance-commission}")
    private String passivePersonalNormalSavingMaintenanceCommission;
    @Value("${constants.passive.account.personal.normal.savings.minimum-daily-average}")
    private String passivePersonalNormalSavingMinimumDailyAverage;
    @Value("${constants.passive.account.personal.normal.savings.transaction-commission}")
    private String passivePersonalNormalSavingTransactionCommission;
    @Value("${constants.passive.account.personal.normal.savings.maximum-number-transaction}")
    private String passivePersonalNormalSavingMaximumNumberTransaction;
    @Value("${constants.passive.account.personal.normal.savings.allowed-day-transaction}")
    private String passivePersonalNormalSavingAllowedDayTransaction;

    @Value("${constants.passive.account.personal.normal.current.maintenance-commission}")
    private String passivePersonalNormalCurrentMaintenanceCommission;
    @Value("${constants.passive.account.personal.normal.current.minimum-daily-average}")
    private String passivePersonalNormalCurrentMinimumDailyAverage;
    @Value("${constants.passive.account.personal.normal.current.transaction-commission}")
    private String passivePersonalNormalCurrentTransactionCommission;
    @Value("${constants.passive.account.personal.normal.current.maximum-number-transaction}")
    private String passivePersonalNormalCurrentMaximumNumberTransaction;
    @Value("${constants.passive.account.personal.normal.current.allowed-day-transaction}")
    private String passivePersonalNormalCurrentAllowedDayTransaction;

    @Value("${constants.passive.account.personal.normal.long-term.maintenance-commission}")
    private String passivePersonalNormalLongTermMaintenanceCommission;
    @Value("${constants.passive.account.personal.normal.long-term.minimum-daily-average}")
    private String passivePersonalNormalLongTermMinimumDailyAverage;
    @Value("${constants.passive.account.personal.normal.long-term.transaction-commission}")
    private String passivePersonalNormalLongTermTransactionCommission;
    @Value("${constants.passive.account.personal.normal.long-term.maximum-number-transaction}")
    private String passivePersonalNormalLongTermMaximumNumberTransaction;
    @Value("${constants.passive.account.personal.normal.long-term.allowed-day-transaction}")
    private String passivePersonalNormalLongTermAllowedDayTransaction;

    @Value("${constants.passive.account.personal.vip.savings.maintenance-commission}")
    private String passivePersonalVipSavingMaintenanceCommission;
    @Value("${constants.passive.account.personal.vip.savings.minimum-daily-average}")
    private String passivePersonalVipSavingMinimumDailyAverage;
    @Value("${constants.passive.account.personal.vip.savings.transaction-commission}")
    private String passivePersonalVipSavingTransactionCommission;
    @Value("${constants.passive.account.personal.vip.savings.maximum-number-transaction}")
    private String passivePersonalVipSavingMaximumNumberTransaction;
    @Value("${constants.passive.account.personal.vip.savings.allowed-day-transaction}")
    private String passivePersonalVipSavingAllowedDayTransaction;

    @Value("${constants.passive.account.enterprise.normal.current.maintenance-commission}")
    private String passiveEnterpriseNormalCurrentMaintenanceCommission;
    @Value("${constants.passive.account.enterprise.normal.current.minimum-daily-average}")
    private String passiveEnterpriseNormalCurrentMinimumDailyAverage;
    @Value("${constants.passive.account.enterprise.normal.current.transaction-commission}")
    private String passiveEnterpriseNormalCurrentTransactionCommission;
    @Value("${constants.passive.account.enterprise.normal.current.maximum-number-transaction}")
    private String passiveEnterpriseNormalCurrentMaximumNumberTransaction;
    @Value("${constants.passive.account.enterprise.normal.current.allowed-day-transaction}")
    private String passiveEnterpriseNormalCurrentAllowedDayTransaction;

    @Value("${constants.passive.account.enterprise.vip.current.maintenance-commission}")
    private String passiveEnterpriseVipCurrentMaintenanceCommission;
    @Value("${constants.passive.account.enterprise.vip.current.minimum-daily-average}")
    private String passiveEnterpriseVipCurrentMinimumDailyAverage;
    @Value("${constants.passive.account.enterprise.vip.current.transaction-commission}")
    private String passiveEnterpriseVipCurrentTransactionCommission;
    @Value("${constants.passive.account.enterprise.vip.current.maximum-number-transaction}")
    private String passiveEnterpriseVipCurrentMaximumNumberTransaction;
    @Value("${constants.passive.account.enterprise.vip.current.allowed-day-transaction}")
    private String passiveEnterpriseVipCurrentAllowedDayTransaction;

}