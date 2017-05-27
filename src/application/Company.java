package application;

import java.sql.Timestamp;

/////////////////////////////////////////////// Jarl og Joakim //////////////////////////////////////////////////

public class Company {

    private String cvrNumber;
    private String name;
    private String address;
    private String zipCode;
    private String email;
    private String phoneNumber;



    private double revenue;
    private String comments;
    private Timestamp createdOn;
    private ContactPerson contactPerson;
    private User createdBy;

    public Company(String cvrNumber, String name, String address, String zipCode, String email, String phoneNumber, String comments, double revenue, Timestamp createdOn, ContactPerson contactPerson, User createdBy) {
        this.cvrNumber      = cvrNumber;
        this.name           = name;
        this.address        = address;
        this.zipCode        = zipCode;
        this.email          = email;
        this.phoneNumber    = phoneNumber;
        this.comments       = comments;
        this.revenue        = revenue;
        this.createdOn      = createdOn;
        this.contactPerson  = contactPerson;
        this.createdBy      = createdBy;
    }

    public Company(double revenue) {
        this.revenue = revenue;
    }

    public Company() {
    }

    public Company(String cvrNumber, String name, String address, String zipCode, String email, String phoneNumber, double revenue, String comments, ContactPerson contactPerson) {
        this.cvrNumber      = cvrNumber;
        this.name           = name;
        this.address        = address;
        this.zipCode        = zipCode;
        this.email          = email;
        this.phoneNumber    = phoneNumber;
        this.revenue        = revenue;
        this.comments       = comments;
        this.contactPerson  = contactPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getCvrNumber() {
        return cvrNumber;
    }

    public void setCvrNumber(String cvrNumber) {
        this.cvrNumber = cvrNumber;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
}
