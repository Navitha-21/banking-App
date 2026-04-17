package org.example.dao;

import org.example.model.Account;
import org.example.model.Transactions;
import org.example.util.DBConnection;
import org.postgresql.util.PSQLException;

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
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return 0;
    }

    @Override
    public double getBalance(String acc_num) throws SQLException{
        String sql="select balance from account where acc_num=?";
        Connection con=DBConnection.getConnection();
        PreparedStatement preparedstatement=con.prepareStatement(sql);
        preparedstatement.setString(1, acc_num);

        ResultSet resultSet = preparedstatement.executeQuery();
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
        preparedStatement.executeUpdate();

        int updatedBalance= preparedStatement.executeUpdate();
        System.out.println("Updated Balance : "+ updatedBalance);
    }

    @Override
    public Account getAccount_id(String acc_num) throws SQLException{
        try{
            String sql="select * from account where acc_num= ? ";
            Connection con=DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, acc_num);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Account account=new Account();
                account.setAcc_num(resultSet.getString("acc_num"));
                account.setBalance(resultSet.getDouble("balance"));

                return account;
            }
        }catch(SQLException ex){
            ex.printStackTrace();

        }
        return null;
    }

    @Override
    public void insertTransactions(String  fromAcc_num, String  toAcc_num, double amount,
                                   String type) throws SQLException{
        try {
            String sql = "insert into transactions(fromAcc_num, toAcc_num, amount, type) values(?, ?, ?, ?) ";
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, fromAcc_num);
            preparedStatement.setString(2, toAcc_num);
            preparedStatement.setDouble(3,amount);
            preparedStatement.setString(4,type);
            preparedStatement.execute();

        } catch (PSQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void getTransactionBalance(String acc_num) throws SQLException{

        String sql="select * from transactions where fromAcc_num=? OR toAcc_num=?";

        Connection con=DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, acc_num);
        preparedStatement.setString(2, acc_num);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){

           System.out.println("ID:"+ resultSet.getInt("id"));
            System.out.println("Type:"+ resultSet.getString("type"));
            System.out.println("Amount:"+ resultSet.getDouble("amount"));
            System.out.println("from_acc:"+ resultSet.getInt("fromAcc_num"));
            System.out.println("to_acc:"+ resultSet.getInt("toAcc_num"));
        }

    }

}
