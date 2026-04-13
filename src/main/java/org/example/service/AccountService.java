package org.example.service;

import org.example.model.Account;
import org.example.model.Transaction;

import java.sql.SQLException;

public interface AccountService {
    void createAccount(Account account) throws SQLException;

    void deposit(String acc_num, double amount) throws SQLException;

    void withdraw(String acc_num, double amount) throws SQLException;

    void transfer(String tAcc_numFrom, String tAcc_numTo, double amount);

    void transactionHistory(String thAcc_num) throws SQLException;
}
