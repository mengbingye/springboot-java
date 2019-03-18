package com.slabs.springbootjava.dao;

import com.slabs.springbootjava.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @create: 2019/03/18 10:55
 */

public interface UserInfoMapper {

    UserInfo selectById(@Param("id") Integer id);

    List<UserInfo> selectAll();
}
