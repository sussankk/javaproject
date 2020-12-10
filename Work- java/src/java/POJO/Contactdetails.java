package POJO;

public class Contactdetails {
    private String country;

    private String telephone;

    private String email;

    private String isreceiveads;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIsreceiveads() {
        return isreceiveads;
    }

    public void setIsreceiveads(String isreceiveads) {
        this.isreceiveads = isreceiveads == null ? null : isreceiveads.trim();
    }
}