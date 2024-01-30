package com.testing.model.pojos;

//@Entity
public class CustomerCard {
    /*
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO)
    */

    private Long CardID;
    private int CardNumber;
    private String ExpiryDate;
    private int CVVNumber;
    private String CardName;
    private Long Customer;

    public CustomerCard(){
        super();
        //TODO Auto-generated Constructor Sub
    }

    public CustomerCard(Long cardId, int cardNumber, String expiryDate, int cvvNumber,String cardName, Long customer){
        super();
        this.CardID = cardId;
        this.CardNumber = cardNumber;
        this.ExpiryDate = expiryDate;
        this.CVVNumber = cvvNumber;
        this.CardName = cardName;
        this.Customer = customer;
    }

    //getters + setters

    public Long getCardID() {
        return CardID;
    }

    public void setCardID(Long cardID) {
        CardID = cardID;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public int getCVVNumber() {
        return CVVNumber;
    }

    public void setCVVNumber(int CVVNumber) {
        this.CVVNumber = CVVNumber;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public Long getCustomer() {
        return Customer;
    }

    public void setCustomer(Long customer) {
        Customer = customer;
    }


}
