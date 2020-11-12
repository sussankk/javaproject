package DAO;

import POJO.BillingAddress;

import java.util.List;

public interface BillingAddressMapper {
    int insert(BillingAddress record);

    int insertSelective(BillingAddress record);

    List<BillingAddress> getBillingAddress();

}