package com.gmail.rak.aleh;

import com.gmail.rak.aleh.model.Account;
import com.gmail.rak.aleh.model.Transaction;
import com.gmail.rak.aleh.model.User;
import com.gmail.rak.aleh.service.AccountService;
import com.gmail.rak.aleh.service.TableService;
import com.gmail.rak.aleh.service.UserService;
import com.gmail.rak.aleh.service.impl.AccountServiceImpl;
import com.gmail.rak.aleh.service.impl.TableServiceImpl;
import com.gmail.rak.aleh.service.impl.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        TableService tableService = new TableServiceImpl();
        tableService.dropTable();
        tableService.createTable();

        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setUserId(1);
        user.setName("Oleg");
        user.setAddress("Minsk");
        userService.registrationNewUser(user);

        Account account = new Account();
        account.setAccountId(1);
        account.setCurrency("USD");
        userService.addAccountToNewUser(user, account);

        AccountService accountService = new AccountServiceImpl();
        Transaction transactionAddingFounds = new Transaction();
        Transaction transactionWithdrawFounds = new Transaction();
        transactionAddingFounds.setTransactionId(1);
        transactionWithdrawFounds.setTransactionId(2);
        accountService.addingFoundsToAccount(transactionAddingFounds, account, 1000);
        //accountService.withdrawalFoundsToAccount(transactionWithdrawFounds, account, 900);
    }
}
