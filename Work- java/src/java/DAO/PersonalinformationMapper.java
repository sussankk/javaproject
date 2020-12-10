package DAO;

import POJO.Personalinformation;

import java.util.List;

public interface PersonalinformationMapper {
    int insert(Personalinformation record);

    int insertSelective(Personalinformation record);

    List<Personalinformation> getPersonalinformation();
}