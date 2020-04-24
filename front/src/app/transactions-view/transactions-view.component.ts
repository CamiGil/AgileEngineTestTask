import { Component, OnInit } from '@angular/core';
import {Transaction} from '../model/transaction';
import {TransactionsService} from '../service/transactions.service';

@Component({
  selector: 'app-transactions-view',
  templateUrl: './transactions-view.component.html',
  styleUrls: ['./transactions-view.component.css']
})
export class TransactionsViewComponent implements OnInit {

  transactions: Transaction[];

  constructor(
    private transactionsService: TransactionsService
  ) {
    this.transactionsService = transactionsService;
  }

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit() {
    this.transactionsService.getTransactions().subscribe(
      transactions => {
        this.transactions = transactions;
      }, error => {
        console.log(error.message);
      }
    );
  }
}
