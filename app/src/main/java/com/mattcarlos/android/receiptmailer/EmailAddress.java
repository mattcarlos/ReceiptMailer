package com.mattcarlos.android.receiptmailer;

public class EmailAddress {
     
    //private variables
    int _id;
    String _email;
     
    // Empty constructor
    public EmailAddress(){
         
    }
    // constructor
    public EmailAddress(int id, String email){
        this._id = id;
        this._email = email;
    }
     
    // constructor
    public EmailAddress(String email){
        this._email = email;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
     
    // setting id
    public void setID(int id){
        this._id = id;
    }
     
    // getting name
    public String getEmail(){
        return this._email;
    }
     
    // setting name
    public void setName(String email){
        this._email = email;
    }
}