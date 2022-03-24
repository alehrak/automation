package com.gmail.rak.aleh.service.impl;

import com.gmail.rak.aleh.model.Account;
import com.gmail.rak.aleh.model.Transaction;
import com.gmail.rak.aleh.service.AccountService;
import com.gmail.rak.aleh.util.ConnectionService;
import com.gmail.rak.aleh.util.impl.ConnectionServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    private final ConnectionService connectionService = new ConnectionServiceImpl();

    @Override
    public void addingFoundsToAccount(Transaction transaction, Account account, Integer founds) throws SQLException {
        if (founds <= 100000000) {
            Connection connection = connectionService.createConnectionSQLite();
            try (PreparedStatement statementFirst = connection.prepareStatement(
                    "SELECT balance FROM Accounts WHERE accountId = ?")) {
                connection.setAutoCommit(false);
                statementFirst.setInt(1, account.getAccountId());
                ResultSet resultSet = statementFirst.executeQuery();
                int balance = resultSet.getInt("balance");
                balance += founds;
                if (balance < 2000000000) {
                    try (PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO Transactions(transactinId, accountId, amount) VALUES (?,?,?);")) {
                        statement.setInt(1, transaction.getTransactionId());
                        statement.setInt(2, account.getAccountId());
                        statement.setInt(3, founds);
                        statement.executeUpdate();
                        try (PreparedStatement preparedStatement = connection.prepareStatement(
                                "UPDATE Accounts SET balance = balance + ? WHERE accountId = ?;")) {
                            preparedStatement.setInt(1, founds);
                            preparedStatement.setInt(2, account.getAccountId());
                            preparedStatement.executeUpdate();
                            connection.commit();
                            double result = balance * 1 / 1000.0;
                            System.out.println("balance replenishment transaction - " + transaction.toString() + " passed successfully");
                            System.out.println("after replenishment, the balance is equal to = " + result);
                        }
                    } catch (SQLException e) {
                        try {
                            connection.rollback();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("the balance can't be more - 2.000.000.000");
                }
            }
        } else {
            System.out.println("maximum amount per transaction = 100.000.000");
        }
    }

    @Override
    public void withdrawalFoundsToAccount(Transaction transaction, Account account, Integer founds) throws SQLException {
        if (founds <= 100000000) {
            Connection connection = connectionService.createConnectionSQLite();
            try (PreparedStatement statementFirst = connection.prepareStatement(
                    "SELECT balance FROM Accounts WHERE accountId = ?")) {
                connection.setAutoCommit(false);
                statementFirst.setInt(1, account.getAccountId());
                ResultSet resultSet = statementFirst.executeQuery();
                int balance = resultSet.getInt("balance");
                balance -= founds;
                if (balance > 0) {
                    try (PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO Transactions(transactinId, accountId, amount) VALUES (?,?,?);")) {
                        connection.setAutoCommit(false);
                        statement.setInt(1, transaction.getTransactionId());
                        statement.setInt(2, account.getAccountId());
                        statement.setInt(3, -founds);
                        statement.executeUpdate();
                        try (PreparedStatement preparedStatement = connection.prepareStatement(
                                "UPDATE Accounts SET balance = balance - ? WHERE accountId = ?;")) {
                            preparedStatement.setInt(1, founds);
                            preparedStatement.setInt(2, account.getAccountId());
                            preparedStatement.executeUpdate();
                            connection.commit();
                            double result = balance * 1 / 1000.0;
                            System.out.println("withdrawal transaction - " + transaction.toString() + " passed successfully");
                            System.out.println("after withdrawal, the balance is equal to = " + result);
                        }
                    } catch (SQLException e) {
                        try {
                            connection.rollback();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("the balance cannot be less - 0");
                }
            }
        } else {
            System.out.println("maximum amount per transaction = 100.000.000");
        }
    }
}
