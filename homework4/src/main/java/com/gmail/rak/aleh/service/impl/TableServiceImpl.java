package com.gmail.rak.aleh.service.impl;

import com.gmail.rak.aleh.service.TableService;
import com.gmail.rak.aleh.util.ConnectionService;
import com.gmail.rak.aleh.util.impl.ConnectionServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.gmail.rak.aleh.constats.TableConstants.*;

public class TableServiceImpl implements TableService {
    private final ConnectionService connectionService = new ConnectionServiceImpl();
    String[] dropTableList = new String[]{DROP_TABLE_TRANSACTIONS, DROP_TABLE_ACCOUNTS, DROP_TABLE_USERS};
    String[] createTableList = new String[]{CREATE_TABLE_USERS, CREATE_TABLE_ACCOUNTS, CREATE_TABLE_TRANSACTIONS};

    @Override
    public void dropTable() {
        Connection connection = connectionService.createConnectionSQLite();
        try (Statement statement = connection.createStatement()) {
            for (String table : dropTableList) {
                statement.execute(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createTable() {
        Connection connection = connectionService.createConnectionSQLite();
        try (Statement statement = connection.createStatement()) {
            for (String table : createTableList) {
                statement.execute(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
