package org.example.dao;

import org.example.model.Account;
import org.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class AcccountDAOImpl implements AccountDAO {

    @Override
    public void createAccount(final Account account) throws SQLException{
        try{
            String sql="insert into account(acc_num, name, city, phone, email, balance)";
            Connection con= DBConnection.getConnection();
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1, account.getAcc_num());
            preparedStatement.setString(2, account.getName());
            preparedStatement.setString(3, account.getCity());
            preparedStatement.setString(4, account.getPhone());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setString(6, account.getBalance());
        } catch(Exception ex) {

        }

    }
}
