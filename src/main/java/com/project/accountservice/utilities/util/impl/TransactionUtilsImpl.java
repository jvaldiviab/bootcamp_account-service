package com.project.accountservice.utilities.util.impl;

import com.project.accountservice.models.dto.Transaction;
import com.project.accountservice.models.request.TransactionDoTransactionRequest;
import com.project.accountservice.utilities.util.ITransactionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class TransactionUtilsImpl implements ITransactionUtils {
    @Override
    public Transaction transactionDoTransactionRequestToTransaction(TransactionDoTransactionRequest transactionDTO) {
        return Transaction.builder()
                .transactionNumber(UUID.randomUUID().toString())
                .type(transactionDTO.getType())
                .amount(transactionDTO.getAmount())
                .build();
    }


}
