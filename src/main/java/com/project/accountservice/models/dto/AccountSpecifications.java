package com.project.accountservice.models.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AccountSpecifications {
    private Double maintenanceCommission; // commission per maintenance
    private Double minimumDailyAverage; // to VIP

    private Double transactionCommission;
    private Integer maximumNumberOfTransaction;
    private Integer allowedDayForTransaction;
}