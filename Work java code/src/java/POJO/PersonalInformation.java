package POJO;

public class PersonalInformation {
    private String title;

    private String firstname;

    private String lastname;

    private Byte iscard;

    private Integer cardnumber;

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

    public Byte getIscard() {
        return iscard;
    }

    public void setIscard(Byte iscard) {
        this.iscard = iscard;
    }

    public Integer getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(Integer cardnumber) {
        this.cardnumber = cardnumber;
    }
}