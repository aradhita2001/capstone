import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Observable, map, of } from "rxjs";
import { AuthService } from "src/app/auth/services/auth.service";
import { User } from "src/app/auth/types/user";
import { TransactionService } from "../../services/transaction.service";
import { Transaction } from "../../types/transaction";

@Component({
  selector: "app-transaction",
  templateUrl: "./transaction.component.html",
  styleUrls: ["./transaction.component.scss"],
})
export class TransactionComponent implements OnInit {
  transactionForm: FormGroup;

  transactionError$: Observable<string>;
  transactionSuccess$: Observable<string>;
  users$: Observable<User[]>;
  isFormSubmitted: boolean = false;
  outstandingBalance$: Observable<number>;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private trnasactionService: TransactionService
  ) {}

  ngOnInit(): void {
    this.transactionForm = this.formBuilder.group({
      user: ["", [Validators.required]],
      amount: ["", ""],
      type: ["", ""],
    });

    // Make sure you check user's outstanding balance and display it in the UI on page load
    // You will also need to load transaction history, if there are any previous transactions for this user 
 
  }

  onSubmit() {
    this.isFormSubmitted = true;
    //@todo:  when a trasaction is submitted make sure relevant fields (transactionAmount, transactionType) are not empty, and make an api call to perform transaction
    // Once transaction is successfully submitted, update transaction history and outstanding balance for the user 
    // If the transaction is not successful due to insufficient balance, display the error message as "Not enough balance to complete transaction"
    // If it is a successful transaction, display the message as "Transaction performed successfully".
  }

  // Use this method fetch transaction history of a particular user
  getAllTransactions() {
    

  }
}
