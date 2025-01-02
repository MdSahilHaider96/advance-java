package org.first.model;

import java.util.List;

public class Store {
    //	column id , Fname LName  ,email , items , address , phn No , total bill
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phnNo;
    private String totalBill;

    public Store() {
    }

    public Store(int id, String firstName, String lastName, String email,  String address, String phnNo, String totalBill) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email; //
        this.address = address;
        this.phnNo = phnNo;
        this.totalBill = totalBill;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    public String getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(String totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phnNo='" + phnNo + '\'' +
                ", totalBill='" + totalBill + '\'' +
                '}';
    }
}
