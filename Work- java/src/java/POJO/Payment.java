package POJO;

public class Payment {
    private String fullName;

    private String email;

    private String address;

    private String city;

    private String state;

    private String zip;

    private String nameoncard;

    private String creditcardnum;

    private String expmonth;

    private Integer expyear;

    private Integer cvv;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getNameoncard() {
        return nameoncard;
    }

    public void setNameoncard(String nameoncard) {
        this.nameoncard = nameoncard == null ? null : nameoncard.trim();
    }

    public String getCreditcardnum() {
        return creditcardnum;
    }

    public void setCreditcardnum(String creditcardnum) {
        this.creditcardnum = creditcardnum == null ? null : creditcardnum.trim();
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

    @Override
    public String toString() {
        return "Payment{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", nameoncard='" + nameoncard + '\'' +
                ", creditcardnum='" + creditcardnum + '\'' +
                ", expmonth='" + expmonth + '\'' +
                ", expyear=" + expyear +
                ", cvv=" + cvv +
                '}';
    }
}