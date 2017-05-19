package gui.Tableviews.objects;

/**
 * Created by Daniel on 17-05-2017.
 */
public class Company {


    private String cvrNumber;
    private String contactPerson;
    private String address;
    private String zipCode;
    private String email;
    private String phoneNumber;

    public Company() {
        this.cvrNumber = "";
        this.contactPerson = "";
        this.address = "";
        this.zipCode = "";
        this.email = "";
        this.phoneNumber = "";
    }

    public Company(String cvrNumber, String contactPerson, String address, String zipCode, String email, String phoneNumber) {
        this.cvrNumber = cvrNumber;
        this.contactPerson = contactPerson;
        this.address = address;
        this.zipCode = zipCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }



    public String getCvrNumber() {
        return cvrNumber;
    }

    public void setCvrNumber(String cvrNumber) {
        this.cvrNumber = cvrNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
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

}
