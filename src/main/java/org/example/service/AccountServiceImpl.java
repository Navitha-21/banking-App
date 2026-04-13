package org.example.service;

import org.example.dao.AccountDAO;
import org.example.dao.AccountDAOImpl;
import org.example.model.Account;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService{

    @Override
    public void createAccount(final Account account) throws SQLException{
        AccountDAO accountDAO=new AccountDAOImpl();
        accountDAO.createAccount(account);
    }

    @Override
    public void deposit(String dAcc_num, double damount) throws SQLException{

        AccountDAO accountDAO=new AccountDAOImpl();
        double balance = accountDAO.getBalance();
        double newBalance = balance + damount;

        accountDAO.updateBalance(dAcc_num, newBalance);

        int id = accountDAO.getAccount_id();
        accountDAO.insertTransaction(dAcc_num, damount);

        System.out.println("Deposit successful!");
    }

    @Override
    public void withdraw(String wAcc_num, double wAmount) throws SQLException {
        AccountDAO accountDAO=new AccountDAOImpl();
        double balance = accountDAO.getBalance(wAcc_num);

        if (balance < wAmount) {
            System.out.println("Insufficient balance!");
            return;
        }
        double newBalance = balance - wAmount;
        accountDAO.updateBalance(wAcc_num, newBalance);

        int id = accountDAO.createAccount(wAcc_num);
        accountDAO.insertTransaction(wAmount);

        System.out.println("Withdraw successful!");
    }



    @Override
    public void transfer(String tAcc_numFrom, String tAcc_numTo, double amount) {
        AccountDAO accountDAO=new AccountDAOImpl();

        double fromBalance = accountDAO.getBalance(tAcc_numFrom);

        if (fromBalance < amount) {
            System.out.println("Insufficient balance!");
            return;
        }

        accountDAO.updateBalance(tAcc_numFrom, fromBalance - amount);

        double toBalance = accountDAO.getBalance(tAcc_numTo);
        accountDAO.updateBalance(tAcc_numTo, toBalance + amount);

        System.out.println("Transfer successful!");
    }

    @Override
    public void transactionHistory(String thAcc_num) throws SQLException{
        AccountDAO accountDAO=new AccountDAOImpl();
        accountDAO.getTransactionBalance();
    }


}
