package com.slabs.springbootjava.service.impl;



import com.slabs.springbootjava.core.ret.ServiceException;
import com.slabs.springbootjava.core.universal.AbstractService;
import com.slabs.springbootjava.dao.UserInfoMapper;
import com.slabs.springbootjava.model.UserInfo;
import com.slabs.springbootjava.service.IUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @create: 2019/03/18 10:58
 */
@Service
public class UserInfoService extends AbstractService<UserInfo> implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo selectById(String id) {

        UserInfo userInfo = this.userInfoMapper.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(userInfo)) {
            throw new ServiceException("暂无该用户");
        }

        return userInfo;
    }
}
