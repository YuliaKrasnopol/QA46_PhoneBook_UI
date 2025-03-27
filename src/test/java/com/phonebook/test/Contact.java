package com.phonebook.test;

public class Contact{ private String lastName;
  private String name;
  private String number;
  private String email;
  private String address;
  private String description;

    public String getLastName() {
        return lastName;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Contact setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Contact setDescription(String description) {
        this.description = description;
        return this;
    }

}