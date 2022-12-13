package com.bharadhi.assignment6.service;


import core.Ledger;
import core.TrialBalanceResult;
import core.chartofaccounts.ChartOfAccounts;
import core.chartofaccounts.ChartOfAccountsBuilder;
import core.transaction.AccountingTransaction;
import core.transaction.AccountingTransactionBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static core.account.AccountSide.CREDIT;
import static core.account.AccountSide.DEBIT;

@Service
public class AccountService {
    String cashAccountNumber = "000001";
    String checkingAccountNumber = "000002";
    String accountsReceivableAccountNumber = "000003";

    // Setup ledger
    ChartOfAccounts coa = ChartOfAccountsBuilder.create().addAccount(cashAccountNumber, "Cash", CREDIT).addAccount(checkingAccountNumber, "Checking", CREDIT).addAccount(accountsReceivableAccountNumber, "Accounts Receivable", DEBIT).build();
    Ledger ledger = new Ledger(coa);
    AccountingTransactionBuilder ab = ledger.createTransaction(null);


public BigDecimal credit(BigDecimal v){
    ab.credit(v,cashAccountNumber);
    return v;
}
public BigDecimal debit(BigDecimal v1){
    ab.debit(v1,cashAccountNumber);
    return v1;
}
public String display(){
    AccountingTransaction t = ab.build();
    ledger.commitTransaction(t);
    TrialBalanceResult trialBalanceResult = ledger.computeTrialBalance();
   return ledger.toString()+trialBalanceResult.toString();
}
}
