package POJO;

import java.util.Date;

public class EuropeanAviation {
    private Integer id;

    private String startcountry;

    private String endcountry;

    private Boolean toorreturn;

    private Date dateofdeparture;

    private Date returndate;

    private String tanktype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartcountry() {
        return startcountry;
    }

    public void setStartcountry(String startcountry) {
        this.startcountry = startcountry == null ? null : startcountry.trim();
    }

    public String getEndcountry() {
        return endcountry;
    }

    public void setEndcountry(String endcountry) {
        this.endcountry = endcountry == null ? null : endcountry.trim();
    }

    public Boolean getToorreturn() {
        return toorreturn;
    }

    public void setToorreturn(Boolean toorreturn) {
        this.toorreturn = toorreturn;
    }

    public Date getDateofdeparture() {
        return dateofdeparture;
    }

    public void setDateofdeparture(Date dateofdeparture) {
        this.dateofdeparture = dateofdeparture;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public String getTanktype() {
        return tanktype;
    }

    public void setTanktype(String tanktype) {
        this.tanktype = tanktype == null ? null : tanktype.trim();
    }
}