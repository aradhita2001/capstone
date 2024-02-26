package com.wecp.service;
 
import java.util.List;

import com.wecp.entities.Transaction;
 


 
public interface TransactionService {
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(long transactionId);
    long addTransaction(Transaction transaction);
    // List<Transaction> getTransactionsByCustomerId(int customerId) throws SQLException;
    List<Transaction> getAllCreditTransactionsByAccountId(long accountId);
    List<Transaction> getAllDebitTransactionsByAccountId(long accountId);
}
    

