package org.example.service;

import org.example.dao.AccountDAO;
import org.example.dao.AccountDAOImpl;
import org.example.model.Account;
import org.example.model.Transaction;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService{

    @Override
    public void createAccount(final Account account) throws SQLException{
        AccountDAO accountDAO=new AccountDAOImpl();
        accountDAO.createAccount(account);
    }

    @Override
    public void deposit(String acc_num, double amount) throws SQLException {

        AccountDAO accountDAO=new AccountDAOImpl();
        double balance = accountDAO.getBalance();
        double newBalance = balance + amount;

        accountDAO.updateBalance(acc_num, newBalance);
        Transaction transaction=new Transaction();
        transaction.setAmount(amount);
        transaction.setDeposit(acc_num);
        accountDAO.insertTransaction(transaction);

        System.out.println("Deposit successful!");
    }

    @Override
    public void withdraw(String acc_num, double amount) throws SQLException {
        AccountDAO accountDAO=new AccountDAOImpl();
        double balance = accountDAO.getBalance();

        if (balance < amount) {
            System.out.println("Insufficient balance!");
            return;
        }
        double newBalance = balance - amount;
        accountDAO.updateBalance(acc_num, newBalance);
        Transaction transaction=new Transaction();
        transaction.setAmount(amount);
        transaction.setWithdraw(acc_num);

        accountDAO.insertTransaction(transaction);

        System.out.println("Withdraw successful!");
    }

    @Override
    public void transfer(String acc_numFrom, String acc_numTo, double amount) throws SQLException {
        AccountDAO accountDAO=new AccountDAOImpl();
        Account from=accountDAO.getAccount_id(acc_numFrom);
        Account to=accountDAO.getAccount_id(acc_numTo);

        if (from.getBalance() < amount) {
            System.out.println("Insufficient balance!");
            return;
        }

        accountDAO.updateBalance(from.getId(), from.getBalance() - amount);
        accountDAO.updateBalance(from.getId(), from.getBalance() + amount);

        Transaction t1=new Transaction();
        t1.setAmount(amount);
        t1.setAccount_id(from.getId());

        Transaction t2 = new Transaction();
        t2.setAmount(amount);
        t2.setAccount_id(to.getId());

        accountDAO.insertTransaction(t1);
        accountDAO.insertTransaction(t2);

        System.out.println("Transfer successful!");
    }

    @Override
    public void transactionHistory(String acc_num) throws SQLException{
        AccountDAO accountDAO=new AccountDAOImpl();
        accountDAO.getTransactionBalance();
    }


}
