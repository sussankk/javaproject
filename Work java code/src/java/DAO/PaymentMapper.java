package DAO;

import POJO.Payment;

import java.util.List;

public interface PaymentMapper {
    int insert(Payment record);

    int insertSelective(Payment record);

    List<Payment> getPayment();

}