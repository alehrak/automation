package com.gmail.rak.aleh.service;

import com.gmail.rak.aleh.model.Account;
import com.gmail.rak.aleh.model.Transaction;

import java.sql.SQLException;

public interface AccountService {
    void addingFoundsToAccount(Transaction transaction, Account account, Integer founds) throws SQLException;
    void withdrawalFoundsToAccount(Transaction transaction,Account account,Integer founds) throws SQLException;
}
