package DAO;

import POJO.Contactdetails;

import java.util.List;

public interface ContactdetailsMapper {
    int insert(Contactdetails record);

    int insertSelective(Contactdetails record);

    List<Contactdetails> getContactdetails();
}