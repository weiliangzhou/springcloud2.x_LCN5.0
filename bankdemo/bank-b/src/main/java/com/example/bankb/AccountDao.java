package com.example.bankb;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountDao {
    @Update("update bank_b set money = money+#{money} where user =#{user}")
    int update(@Param("money") String money, @Param("user") String user);
}
