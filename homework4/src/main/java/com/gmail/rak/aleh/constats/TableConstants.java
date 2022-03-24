package com.gmail.rak.aleh.constats;

public class TableConstants {
    public static final String DROP_TABLE_TRANSACTIONS = "DROP TABLE IF EXISTS Transactions;";
    public static final String DROP_TABLE_ACCOUNTS = "DROP TABLE IF EXISTS Accounts;";
    public static final String DROP_TABLE_USERS = "DROP TABLE IF EXISTS Users;";
    public static final String CREATE_TABLE_USERS = "CREATE TABLE Users(\n" +
            "    userId INTEGER(10) PRIMARY KEY,\n" +
            "    name VARCHAR(50) NOT NULL,\n" +
            "    address VARCHAR(50)\n" +
            ");";
    public static final String CREATE_TABLE_ACCOUNTS = "CREATE TABLE Accounts(\n" +
            "    accountId INTEGER(10) PRIMARY KEY,\n" +
            "    userId INTEGER(10),\n" +
            "    balance INTEGER(15) DEFAULT 0,\n" +
            "    currency VARCHAR(10),\n" +
            "    FOREIGN KEY (userId) REFERENCES Users (userId)\n" +
            ");";
    public static final String CREATE_TABLE_TRANSACTIONS = "CREATE TABLE Transactions(\n" +
            "    transactinId INTEGER(10) PRIMARY KEY,\n" +
            "    accountId INTEGER(10) NOT NULL,\n" +
            "    amount INTEGER(15) ,\n" +
            "    FOREIGN KEY (accountId) REFERENCES Accounts (accountId)\n" +
            ");";
}
