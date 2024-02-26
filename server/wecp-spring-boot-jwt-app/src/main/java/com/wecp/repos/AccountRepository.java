package com.wecp.repos;

import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.entities.Account;
 
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> getAccountsByCustomerUserId(long userId);
    Account findByAccountId(long accountId);
}
 