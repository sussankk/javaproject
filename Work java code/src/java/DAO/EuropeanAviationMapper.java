package DAO;

import POJO.EuropeanAviation;

import java.util.List;

public interface EuropeanAviationMapper {
    int insert(EuropeanAviation record);

    int insertSelective(EuropeanAviation record);

    List<EuropeanAviation> getEuropeanAviation();

}