package models;
//============================================================================
// Name        : Customer.java
// Author      : Tyrien Gilpin
// Version     : 1
// Copyright   : Your copyright notice
// Description : Customer Model Class
//============================================================================
import java.io.Serializable;

public class Customer implements Serializable {
	private String id;
    private String firstName;
    private String lastName;
    private Date DOB;
    private String address;
    private String telephone;
    private String email;
    private Date membershipDate;
    private Date membershipExpiryDate;

    //Default Constructor
    public Customer() {
        id = "N/A";
        firstName = "N/A";
        lastName = "N/A";
        DOB = new Date();
        address = "N/A";
        telephone = "N/A";
        email = "N/A";
        membershipDate = new Date();
        membershipExpiryDate = new Date();
    }

    //Primary Constructor
    public Customer(String id, String firstName, String lastName, Date dOB, String address, String telephone,
                    String email, Date membershipDate, Date membershipExpiryDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        DOB = dOB;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.membershipDate = membershipDate;
        this.membershipExpiryDate = membershipExpiryDate;
    }

    //Copy Constructor
    public Customer(Customer customer) {
        this.id = customer.id;
        this.firstName = customer.firstName;
        this.lastName = customer.lastName;
        DOB = customer.DOB;
        this.address = customer.address;
        this.telephone = customer.telephone;
        this.email = customer.email;
        this.membershipDate = customer.membershipDate;
        this.membershipExpiryDate = customer.membershipExpiryDate;
    }

    //Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date dOB) {
        DOB = dOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public Date getMembershipExpiryDate() {
        return membershipExpiryDate;
    }

    public void setMembershipExpiryDate(Date membershipExpiryDate) {
        this.membershipExpiryDate = membershipExpiryDate;
    }

    //Method to display a customer
    public void displayCustomer() {
        System.out.println("Customer ID: " + getId() + "\nFirstname: " + getFirstName() + "\nLastName: "
                + getLastName() + "\nDOB: " + getDOB() + "\nAddress: " + getAddress() + "\nTelephone: "
                + getTelephone() + "\nEmail: " + getEmail() + "\nDate Joined" + getMembershipDate()
                + "Membership Expiration Date: " + getMembershipExpiryDate());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", membershipDate=" + membershipDate +
                ", membershipExpiryDate=" + membershipExpiryDate +
                '}';
    }
}
