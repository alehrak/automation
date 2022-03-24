CREATE TABLE Users
(
    userId  INTEGER(10) PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    address VARCHAR(50)
);
CREATE TABLE Accounts
(
    accountId INTEGER(10) PRIMARY KEY,
    userId    INTEGER(10),
    balance   INTEGER(15),
    currency  VARCHAR(10),
    FOREIGN KEY (userId) REFERENCES Users (userId)
);
CREATE TABLE Transactions
(
    transactinId INTEGER(10) PRIMARY KEY,
    accountId    INTEGER(10) NOT NULL,
    amount      INTEGER(15),
    FOREIGN KEY (accountId) REFERENCES Accounts (accountId)
);