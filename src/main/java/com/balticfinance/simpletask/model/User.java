package com.balticfinance.simpletask.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty ("Firstname")
   private String firstName;

    @JsonProperty ("Lastname")
   private String lastName;

    @JsonProperty ("Citizenship")
   private String citizenship;

    @JsonProperty ("Age")
   private  int age;

    public User (String firstName , String lastName, String citizenship, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenship = citizenship;
        this.age = age;
    }

    public String getFirstName (){
        return firstName;
    }

    public void setFirstName (String firstName){
        this.firstName = firstName;
    }

    public String getLastName (){
        return lastName;
    }

    public void setLastName (String lastName){
        this.lastName = lastName;
    }

    public String getCitizenship (){
        return citizenship;
    }

    public void setCitizenship (String citizenship){
        this.citizenship = citizenship;
    }

    public int getAge (){
        return age;
    }

    public void setAge (int age){
        this.age = age;
    }

    @Override
    public String toString (){
        return "User{" +
                "FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", Citizenship='" + citizenship + '\'' +
                ", Age=" + age +
                '}';
    }
}
