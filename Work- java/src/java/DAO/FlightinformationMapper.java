package DAO;

import POJO.Flightinformation;

import java.util.List;

public interface FlightinformationMapper {
    int insert(Flightinformation record);

    int insertSelective(Flightinformation record);

    List<Flightinformation> getFlightinformation();
}