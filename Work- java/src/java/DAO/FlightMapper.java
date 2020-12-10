package DAO;

import POJO.Flight;

import java.util.List;

public interface FlightMapper {
    int insert(Flight record);

    int insertSelective(Flight record);

    List<Flight> getFlight();
}