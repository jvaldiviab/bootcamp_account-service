package com.project.accountservice.models.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AccountFindBalancesResponse {
    private String accountId;
    private Double currentBalance;
    private AccountTypeFindBalancesResponse accountType;
}