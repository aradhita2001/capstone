package com.wecp.repos;
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.entities.Transaction;
 


 
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    List<Transaction> findBySourceAccountId(long accountId);
    List<Transaction> findByDestinationAccountId(long accountId);
}
    
