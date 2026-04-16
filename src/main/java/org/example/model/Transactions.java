package org.example.model;

public class Transactions {
    private int id;
    private double amount;
    private String type;
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

    public String getType(){
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }



    public String getAccount_id(){
        return account_id;
    }
    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }



}
