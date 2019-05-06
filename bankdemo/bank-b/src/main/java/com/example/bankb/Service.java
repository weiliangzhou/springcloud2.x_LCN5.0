package com.example.bankb;


import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author 二师兄
 * @Date 2019/2/26 17:52
 **/
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    AccountDao accountDao;

    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public String addMoney(String money, String user) {
        int res = accountDao.update(money, user);
        return res > 0 ? "success" : "error";
    }
}
