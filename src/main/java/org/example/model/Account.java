package org.example.model;

public class Account {
    private int id;
    private String acc_num;
    private String name;
    private String city;
    private String phone;
    private String email;
    private double balance;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getAcc_num(){
        return acc_num;
    }
    public void setAcc_num(String acc_num) {
        this.acc_num = acc_num;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city=city;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone =phone;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public double getBalance(){

        return balance;
    }
    public void setBalance(double balance) {

        this.balance = balance;
    }


}
