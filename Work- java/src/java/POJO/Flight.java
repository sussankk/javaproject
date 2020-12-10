package POJO;

public class Flight {
    private Integer flightcode;

    private String flightnum;

    private String price;

    public Integer getFlightcode() {
        return flightcode;
    }

    public void setFlightcode(Integer flightcode) {
        this.flightcode = flightcode;
    }

    public String getFlightnum() {
        return flightnum;
    }

    public void setFlightnum(String flightnum) {
        this.flightnum = flightnum == null ? null : flightnum.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightcode=" + flightcode +
                ", flightnum='" + flightnum + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}