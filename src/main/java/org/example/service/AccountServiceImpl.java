package org.example.service;

import org.example.dao.AccountDAO;
import org.example.dao.AccountDAOImpl;
import org.example.model.Account;
import org.example.model.Transactions;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService{

    @Override
    public void createAccount(final Account account) throws SQLException{
        AccountDAO accountDAO=new AccountDAOImpl();
        accountDAO.createAccount(account);
        System.out.println("Account created");
    }

    @Override
    public void updateBalance(String acc_num, double balance) throws SQLException{
        AccountDAO accountDAO=new AccountDAOImpl();
        accountDAO.updateBalance(acc_num,balance);
    }
    @Override
    public void deposit(String acc_num, double amount) throws SQLException {

        AccountDAO accountDAO=new AccountDAOImpl();
        Account account= (Account) accountDAO.getAccount_id(acc_num);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        double balance = account.getBalance();
        double newBalance = balance + amount;

        accountDAO.updateBalance(account.getAcc_num(), newBalance);
        accountDAO.insertTransactions((acc_num),null, amount, "Deposit");

        System.out.println("Deposit successful!");
    }

    @Override
    public void withdraw(String acc_num, double amount) throws SQLException {
        AccountDAO accountDAO=new AccountDAOImpl();
        Account account= (Account) accountDAO.getAccount_id(acc_num);

        if (account.getBalance() < amount) {
            System.out.println("Insufficient balance!");
            return;
        }
        double newBalance = account.getBalance() - amount;
        accountDAO.updateBalance(acc_num, newBalance);

        accountDAO.insertTransactions((acc_num), null, amount, "Withdraw");

        System.out.println("Withdraw successful!");
    }

    @Override
    public void transfer(String fromAcc_num, String toAcc_num, double amount) throws SQLException {
        AccountDAO accountDAO=new AccountDAOImpl();
        Account from= (Account) accountDAO.getAccount_id(String.valueOf(fromAcc_num));
        if(from==null){
            System.out.println("account not found");
            return;
        }
        double balance=from.getBalance();
        if(balance<amount){
            System.out.println("Insufficient Balance");

        } else {
            accountDAO.updateBalance(fromAcc_num, from.getBalance()-amount);
            Account to= (Account) accountDAO.getAccount_id(String.valueOf(toAcc_num));
            double tobalance=to.getBalance();

            accountDAO.updateBalance(toAcc_num, from.getBalance() + amount);
            accountDAO.insertTransactions(fromAcc_num, toAcc_num, amount, "Transfer");


            System.out.println("Transfer successful!");

        }


    }

    @Override
    public void transactionHistory(String acc_num) throws SQLException{
        AccountDAO accountDAO=new AccountDAOImpl();
        accountDAO.getTransactionBalance(acc_num);

    }


}
