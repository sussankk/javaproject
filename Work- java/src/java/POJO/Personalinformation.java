package POJO;

public class Personalinformation {
    private String title;

    private String firstname;

    private String lastname;

    private String passportnum;

    private String email;

    private String telephone;

    private String ismember;

    private String membershipcardnum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname == null ? null : firstname.trim();
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    public String getPassportnum() {
        return passportnum;
    }

    public void setPassportnum(String passportnum) {
        this.passportnum = passportnum == null ? null : passportnum.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getIsmember() {
        return ismember;
    }

    public void setIsmember(String ismember) {
        this.ismember = ismember == null ? null : ismember.trim();
    }

    public String getMembershipcardnum() {
        return membershipcardnum;
    }

    public void setMembershipcardnum(String membershipcardnum) {
        this.membershipcardnum = membershipcardnum == null ? null : membershipcardnum.trim();
    }
}