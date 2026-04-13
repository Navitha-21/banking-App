package org.example.dao;

import org.example.model.Account;
import org.example.model.Transaction;

import java.sql.SQLException;

public interface AccountDAO {

    int createAccount(Account account) throws SQLException;

    double getBalance() throws SQLException;

    void updateBalance(String acc_num, double balance) throws SQLException;

    int getAccount_id() throws SQLException;

    void insertTransaction(Transaction transaction) throws SQLException;

    void getTransactionBalance() throws SQLException;


}
