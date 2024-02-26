package com.wecp.service;

import java.util.List;

import com.wecp.entities.Account;
 
public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(long accountId);
    long addAccount(Account accounts);
    void updateAccount(Account accounts);
    void deleteAccount(long accountId);
    List<Account> getAccountsByUser(long userId);
}