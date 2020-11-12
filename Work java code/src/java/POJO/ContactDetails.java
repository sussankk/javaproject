package POJO;

public class ContactDetails {
    private String countrycode;

    private Integer telephone;

    private String emailaddress;

    private Boolean iswantcustommadeemail;

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode == null ? null : countrycode.trim();
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress == null ? null : emailaddress.trim();
    }

    public Boolean getIswantcustommadeemail() {
        return iswantcustommadeemail;
    }

    public void setIswantcustommadeemail(Boolean iswantcustommadeemail) {
        this.iswantcustommadeemail = iswantcustommadeemail;
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "countrycode='" + countrycode + '\'' +
                ", telephone=" + telephone +
                ", emailaddress='" + emailaddress + '\'' +
                ", iswantcustommadeemail=" + iswantcustommadeemail +
                '}';
    }
}