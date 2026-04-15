package org.example.service;

import org.example.model.Account;
import org.example.model.Transaction;

import java.sql.SQLException;

public interface AccountService {
    void createAccount(Account account) throws SQLException;

    void deposit(String acc_num, double amount) throws SQLException;

    void withdraw(String acc_num, double amount) throws SQLException;

    void transfer(String acc_numFrom, String acc_numTo, double amount) throws SQLException;

    void transactionHistory(String acc_num) throws SQLException;
}
