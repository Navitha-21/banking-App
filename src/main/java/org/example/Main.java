package org.example;

import org.example.dao.AccountDAO;
import org.example.dao.AccountDAOImpl;
import org.example.util.DBConnection;
import org.example.model.Account;
import org.example.model.Transaction;
import org.example.service.AccountService;
import org.example.service.AccountServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws SQLException {

        DBConnection.getConnection();
        System.out.println("is connected");

        Scanner sc=new Scanner(System.in);
        AccountService service=new AccountServiceImpl();
        int choice;
        do{
            System.out.println("1.Create Account:");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    Account account=new Account();
                    sc.nextLine();
                    System.out.println("Enter Account number: ");
                    String acc_num=sc.nextLine();
                    account.setAcc_num(acc_num);

                    System.out.println("Enter name: ");
                    String name=sc.nextLine();
                    account.setName(name);

                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    account.setCity(city);

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    account.setPhone(phone);

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    account.setEmail(email);

                    System.out.print("Balance: ");
                    double balance = sc.nextDouble();
                    account.setBalance(balance);

                    sc.nextLine();
                    service.createAccount(account);

                    break;
                case 2:
                    System.out.print("Account Number: ");
                    String dAcc_num = sc.next();
                    sc.nextLine();
                    System.out.print("Amount: ");
                    double dAmount = sc.nextDouble();
                    service.deposit(dAcc_num, dAmount);
                    break;
                case 3:
                    System.out.print("Account No: ");
                    String wAcc_num = sc.next();
                    sc.nextLine();
                    System.out.print("Amount: ");
                    double wAmount = sc.nextDouble();

                    service.withdraw(wAcc_num, wAmount);
                    break;
                case 4:
                    System.out.print("From Account: ");
                    String tAcc_numFrom= sc.nextLine();
                    System.out.print("To Account: ");
                    String tAcc_numTo= sc.nextLine();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    service.transfer(tAcc_numFrom, tAcc_numTo, amount);
                    break;

                case 5:
                    System.out.print("Account No: ");
                    String thAcc_num = sc.nextLine();

                    service.transactionHistory(thAcc_num);
                    break;

                case 6:
                    System.exit(0);

            }
        }while(choice!=6);
        System.out.println("Select correct choice");

    }
}
