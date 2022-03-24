package com.gmail.rak.aleh.service;

import com.gmail.rak.aleh.model.Account;
import com.gmail.rak.aleh.model.User;

import java.sql.SQLException;

public interface UserService {
    void registrationNewUser(User user);
    void addAccountToNewUser(User user ,Account account) throws SQLException;
}
