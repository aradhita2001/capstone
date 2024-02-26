package com.wecp.service;
import java.util.List;
     
     
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import com.wecp.entities.Account;
import com.wecp.entities.Transaction;
import com.wecp.exception.AccountNotFoundException;
import com.wecp.exception.OutOfBalanceException;
import com.wecp.repos.AccountRepository;
import com.wecp.repos.TransactionRepository;
     



    @Service
    public class TransactionServiceImpl implements TransactionService{
        private TransactionRepository transactionRepository;
        private AccountRepository accountRepository;
     
        @Autowired
        public TransactionServiceImpl(TransactionRepository transactionRepository,AccountRepository accountRepository) {
            this.transactionRepository = transactionRepository;
            this.accountRepository = accountRepository;
        }
     
        @Override
        public List<Transaction> getAllTransactions() {
            return transactionRepository.findAll();
        }
     
        @Override
        public Transaction getTransactionById(long transactionId) {
            return transactionRepository.findById(transactionId).orElse(null);
        }
     
        @Override
        public long addTransaction(Transaction transaction) {
            Account srcAccount = accountRepository.findByAccountId(transaction.getSourceAccountId());
            Account desAccount = accountRepository.findByAccountId(transaction.getDestinationAccountId());
            if(srcAccount == null || desAccount == null){
                throw new AccountNotFoundException("AccountId "+transaction.getDestinationAccountId()+ " not found");
            }
            double srcBalance = srcAccount.getBalance();
            double desBalance = desAccount.getBalance();
            if (srcBalance < transaction.getAmount()) {
                throw new OutOfBalanceException("Insufficient Balance");
            }
            srcBalance = srcBalance - transaction.getAmount();        
            desBalance = desBalance + transaction.getAmount();
     
            srcAccount.setBalance(srcBalance);
            desAccount.setBalance(desBalance);
            accountRepository.save(srcAccount);
            accountRepository.save(desAccount);
            return transactionRepository.save(transaction).getTransactionId();
        }
     
     
        @Override
        public List<Transaction> getAllDebitTransactionsByAccountId(long accountId) {
           
            List<Transaction> transactionsForAccount = transactionRepository.findBySourceAccountId(accountId);
            return transactionsForAccount;
        }
     
        @Override
        public List<Transaction> getAllCreditTransactionsByAccountId(long accountId) {
            List<Transaction> transactionsForAccount = transactionRepository.findByDestinationAccountId(accountId);
            return transactionsForAccount;
        }
     
       
    }

