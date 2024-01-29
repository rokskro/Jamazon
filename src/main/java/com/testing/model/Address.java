package com.testing.model;

//@Entity
public class Address {

    /*
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
     */
    private Long AddressID;
    private String HouseNumber;
    private String StreetAddress;
    private String City;
    private String PostCode;
    private Long Customer;

    public Address(){
        super();
        //TODO Auto-generated Constructor Stub
    }

    public Address(String houseNo, String streetAdd, String city, String postCode, Long customer){
        super();
        this.HouseNumber = houseNo;
        this.StreetAddress = streetAdd;
        this.City = city;
        this.PostCode = postCode;
        this.Customer = customer;
    }

    //Getters + Setters

    public Long getAddressID() {
        return AddressID;
    }

    public void setAddressID(Long addressID) {
        AddressID = addressID;
    }

    public String getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        HouseNumber = houseNumber;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        StreetAddress = streetAddress;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public Long getCustomer() {
        return Customer;
    }

    public void setCustomer(Long customer) {
        Customer = customer;
    }


}
