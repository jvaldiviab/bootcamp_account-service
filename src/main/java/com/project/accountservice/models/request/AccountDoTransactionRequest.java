package com.project.accountservice.models.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AccountDoTransactionRequest {
    private String id;
    private TransactionDoTransactionRequest transaction;
    private String targetId;
}
