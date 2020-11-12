package DAO;

import POJO.PersonalInformation;

import java.util.List;

public interface PersonalInformationMapper {
    int insert(PersonalInformation record);

    int insertSelective(PersonalInformation record);

    List<PersonalInformation> getPersonalInformation();

}