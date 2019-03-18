package com.slabs.springbootjava.service.impl;

import com.slabs.springbootjava.dao.UserInfoMapper;
import com.slabs.springbootjava.model.UserInfo;
import com.slabs.springbootjava.service.IUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @create: 2019/03/18 10:58
 */
@Service
public class UserInfoService implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectById(Integer id) {
        return this.userInfoMapper.selectById(id);
    }
}
