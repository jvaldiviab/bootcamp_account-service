package com.project.accountservice.models.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TransactionDoTransactionRequest {
    private String type;
    private Double amount;
}
