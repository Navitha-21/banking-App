package org.example.model;

public class Transaction {
    private int id;
    private double amount;
    private String withdraw;
    private String deposit;
    public String account_id;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount) {

        this.amount = amount;
    }

    public String getWithdraw(){
        return withdraw;
    }
    public void setWithdraw(String withdraw) {
        this.withdraw = withdraw;
    }

    public String getDeposit(){
        return deposit;
    }
    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getAccount_id(){
        return account_id;
    }
    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }


}
