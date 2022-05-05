package com.project.accountservice.utilities.util;

import com.project.accountservice.models.dto.Transaction;
import com.project.accountservice.models.request.TransactionDoTransactionRequest;

public interface ITransactionUtils {

    Transaction transactionDoTransactionRequestToTransaction(TransactionDoTransactionRequest operationDTO);

}
