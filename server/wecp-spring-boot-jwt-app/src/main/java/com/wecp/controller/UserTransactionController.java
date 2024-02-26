package com.wecp.controller;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wecp.entities.User;
import com.wecp.entities.UserTransaction;
import com.wecp.repos.UserRepository;
import com.wecp.repos.UserTransactionRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserTransactionController {
	@Autowired
	UserTransactionRepository userTransactionRepository;

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public ResponseEntity<?> transact(@RequestBody UserTransaction transaction)
			throws Exception {
			/**
			 * @todo Add validations on the incoming transaction object to make sure all the important attributes are not null
			 */

			 /**
			  * @todo Make sure the User exists in the database table for the user id passed.
			  */

			 /**
			  * @todo Add code to insert a new UserTransaction record for CREDIT/DEBIT types.
			  *	@todo Make sure if the outstanding balance is less than the debit amount, you don't allow the transaction record to be created
			  *	@todo Throw an Exception with 'NOT_ENOUGH_BALANCE' message
			  */
			if(transaction.getTransactionType().equals("CREDIT")) {
				
			}
			else if(transaction.getTransactionType().equals("DEBIT")){
				
			}

		Map<String, String> data = new HashMap<>();
		data.put("success", "Transaction performed successfully");
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
