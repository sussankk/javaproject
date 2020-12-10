package POJO;

import java.util.Date;

public class Flightinformation {
    private String flightnum;

    private Date departuredate;

    private String passportnum;

    public String getFlightnum() {
        return flightnum;
    }

    public void setFlightnum(String flightnum) {
        this.flightnum = flightnum == null ? null : flightnum.trim();
    }

    public Date getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(Date departuredate) {
        this.departuredate = departuredate;
    }

    public String getPassportnum() {
        return passportnum;
    }

    public void setPassportnum(String passportnum) {
        this.passportnum = passportnum == null ? null : passportnum.trim();
    }
}