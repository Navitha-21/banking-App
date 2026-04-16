package org.example.dao;

import org.example.model.Account;
import org.example.model.Transaction;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();

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
        preparedStatement.setDouble(1, balance);
        preparedStatement.setString(2, acc_num);

        int updatedBalance= preparedStatement.executeUpdate();
        System.out.println("Updated Balance : "+ updatedBalance);
    }

    @Override
    public Account getAccount_id(String acc_num) throws SQLException{
        try{
            String sql="select * from account where acc_num=?";
            Connection con=DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Account account=new Account();
                account.setId(resultSet.getString("id"));
                account.setAcc_num(resultSet.getString("acc_num"));
                account.setName(resultSet.getString("name"));
                account.setBalance(resultSet.getDouble("balance"));

                return account;
            }
        }catch(SQLException ex){
            ex.printStackTrace();

        }
        return null;
    }

    @Override
    public void insertTransaction(final Transaction transaction) throws SQLException{
        try {
            String sql = "insert into transaction(amount, type, account_id) values(?, ?, ?)";
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, transaction.getAmount());
            preparedStatement.setString(2, transaction.getType());
            preparedStatement.setString(3, transaction.getAccount_id());
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public List<Transaction> getTransactionBalance(String account_id) throws SQLException{
        List<Transaction> list = new ArrayList<>();

        try{
            String sql="select * from transaction where acc_num=?";
            Connection con=DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("Amount:" + resultSet.getDouble ("amount") +
                        " Deposit: " + resultSet.getString("deposit") +
                        " Withdraw: " + resultSet.getString("withdraw"));
            }
        }catch(SQLException ex){

        }
        return list;
    }




}
