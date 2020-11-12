package POJO;

public class Payment {
    private String nameoncard;

    private String creditcardnumber;

    private String expmonth;

    private Integer expyear;

    private Integer cvv;

    public String getNameoncard() {
        return nameoncard;
    }

    public void setNameoncard(String nameoncard) {
        this.nameoncard = nameoncard == null ? null : nameoncard.trim();
    }

    public String getCreditcardnumber() {
        return creditcardnumber;
    }

    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber == null ? null : creditcardnumber.trim();
    }

    public String getExpmonth() {
        return expmonth;
    }

    public void setExpmonth(String expmonth) {
        this.expmonth = expmonth == null ? null : expmonth.trim();
    }

    public Integer getExpyear() {
        return expyear;
    }

    public void setExpyear(Integer expyear) {
        this.expyear = expyear;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
}