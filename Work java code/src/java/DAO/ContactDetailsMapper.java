package DAO;

import POJO.ContactDetails;

import java.util.List;

public interface ContactDetailsMapper {
    int insert(ContactDetails record);

    int insertSelective(ContactDetails record);

    List<ContactDetails> getContactDetails();

}