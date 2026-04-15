package org.example.dao;

import org.example.model.Account;
import org.example.model.Transaction;
import org.example.util.DBConnection;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public int createAccount(final Account account) throws SQLException {
        try {
            String sql = "insert into account(acc_num, name, city, phone, email, balance) values(?, ?, ?, ?, ?, ?)";
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, account.getAcc_num());
            preparedStatement.setString(2, account.getName());
            preparedStatement.setString(3, account.getCity());
            preparedStatement.setString(4, account.getPhone());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setDouble(6, account.getBalance());
        } catch (SQLException ex) {

        }
        return 0;
    }

    @Override
    public double getBalance() throws SQLException{
        String sql="select balance from account where acc_num=?";
        Connection con=DBConnection.getConnection();
        Statement statement=con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getDouble("balance"));

        }
        return 0;
    }

    @Override
    public void updateBalance(String acc_num, double balance) throws SQLException{
        String sql="update account set balance=? where acc_num=?";
        Connection con=DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, acc_num);
        preparedStatement.setDouble(2, balance);

        int updatedBalance= preparedStatement.executeUpdate();
        System.out.println("Updated Balance : "+ updatedBalance);
    }

    @Override
    public Object getAccount_id(String acc_numFrom) throws SQLException{
        try{
            String sql="select id from account where acc_num=?";
            Connection con=DBConnection.getConnection();
            Statement statement=con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Account account=new Account();
                account.setId(resultSet.getString("id"));
                account.setAcc_num(resultSet.getString("acc_num"));
                account.setName(resultSet.getString("name"));
                account.setBalance(resultSet.getDouble("balance"));
                return account;
            }
        }catch(SQLException ex){

        }
        return null;
    }

    @Override
    public void insertTransaction(final Transaction transaction) throws SQLException{
        try {
            String sql = "insert into transaction(amount, deposit, withdraw, account_id) values(?, ?, ?, ?)";
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, transaction.getAmount());
            preparedStatement.setString(2, transaction.getDeposit());
            preparedStatement.setString(3, transaction.getWithdraw());
            preparedStatement.setString(4, transaction.getAccount_id());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    @Override
    public void getTransactionBalance() throws SQLException{
        try{
            String sql="select * from transaction where acc_num=?";
            Connection con=DBConnection.getConnection();
            Statement statement=con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("Amount:" + resultSet.getDouble ("amount") +
                        " Deposit: " + resultSet.getString("deposit") +
                        " Withdraw: " + resultSet.getString("withdraw"));
            }
        }catch(SQLException ex){

        }
    }




}
