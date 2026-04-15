package org.example.dao;

import org.example.model.Account;
import org.example.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {

    int createAccount(Account account) throws SQLException;

    double getBalance() throws SQLException;

    void updateBalance(String acc_num, double balance) throws SQLException;

    Object getAccount_id(String acc_numFrom) throws SQLException;

    void insertTransaction(Transaction transaction) throws SQLException;

    List<Transaction> getTransactionBalance() throws SQLException;

}
