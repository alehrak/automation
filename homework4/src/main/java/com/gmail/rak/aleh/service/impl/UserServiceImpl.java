package com.gmail.rak.aleh.service.impl;

import com.gmail.rak.aleh.model.Account;
import com.gmail.rak.aleh.model.User;
import com.gmail.rak.aleh.service.UserService;
import com.gmail.rak.aleh.util.ConnectionService;
import com.gmail.rak.aleh.util.impl.ConnectionServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private final ConnectionService connectionService = new ConnectionServiceImpl();

    @Override
    public void registrationNewUser(User user) {
        Connection connection = connectionService.createConnectionSQLite();
        try (PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO Users(userId, name, address) VALUES (?,?,?);")) {
            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("an error occurred while adding user:" + user.toString());
        }
    }

    @Override
    public void addAccountToNewUser(User user, Account account) throws SQLException {
        Connection connection = connectionService.createConnectionSQLite();
        try {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement
                    ("SELECT accountId FROM Accounts WHERE userId = ? AND currency = ?;")) {
                statement.setInt(1, user.getUserId());
                statement.setString(2, account.getCurrency());
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.isClosed()){
                    try (PreparedStatement preparedStatement = connection.prepareStatement
                            ("INSERT INTO Accounts(accountId, userId, currency) VALUES (?,?,?);")) {
                        preparedStatement.setInt(1,account.getAccountId());
                        preparedStatement.setInt(2, user.getUserId());
                        preparedStatement.setString(3, account.getCurrency());
                        preparedStatement.executeUpdate();
                        connection.commit();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("an account in this currency has already been created for this user");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }
}
