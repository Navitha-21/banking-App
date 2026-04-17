package org.example.dao;

import org.example.model.Account;

import java.sql.SQLException;

public interface AccountDAO {

    int createAccount(final Account account) throws SQLException;

    double getBalance(String acc_num) throws SQLException;

    void updateBalance(String acc_num, double balance) throws SQLException;

    Object getAccount_id(String acc_num) throws SQLException;

    void insertTransactions(String  fromAcc_num, String  toAcc_num, double amount, String type) throws SQLException;

    void getTransactionBalance(String account_id) throws SQLException;

}
