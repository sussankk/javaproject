package DAO;

import POJO.Country;

import java.util.List;

public interface CountryMapper {
    int insert(Country record);

    int insertSelective(Country record);

    List<Country> getCountry();

}