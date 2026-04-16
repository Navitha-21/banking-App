package org.example.dao;

import org.example.model.Account;
import org.example.model.Transactions;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {

    int createAccount(final Account account) throws SQLException;

    double getBalance(String acc_num) throws SQLException;

    void updateBalance(String acc_num, double balance) throws SQLException;

    Object getAccount_id(String acc_num) throws SQLException;

    void insertTransactions(Transactions transaction) throws SQLException;

    List<Transactions> getTransactionBalance(String account_id) throws SQLException;

}
