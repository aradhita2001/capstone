package com.wecp.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.entities.Account;
import com.wecp.exception.AccountNotFoundException;
import com.wecp.repos.AccountRepository;
 
@Service
public class AccountServiceImpl implements AccountService{
   
    private AccountRepository accountRepository;
   
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
 
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
 
    @Override
    public List<Account> getAccountsByUser(long customerId) {
        return accountRepository.getAccountsByCustomerUserId(customerId);
    }
 
    @Override
    public Account getAccountById(long accountId) {
        Optional<Account> accounts = accountRepository.findById(accountId);
        if (accounts.isPresent()) {
            return accounts.get();
        }
       
        throw new AccountNotFoundException("No accounts found linked with this accountId");
    }
 
    @Override
    public long addAccount(Account accounts) {
        return accountRepository.save(accounts).getAccountId();
    }
 
    @Override
    public void updateAccount(Account accounts) {
        Account account = accountRepository.findByAccountId(accounts.getAccountId());
        account.setAccountType(accounts.getAccountType());
        account.setBalance(accounts.getBalance());
        accountRepository.save(account);
    }
 
    @Override
    public void deleteAccount(long accountId) {
        accountRepository.deleteById(accountId);
    }
}