package com.slabs.springbootjava.service.impl;

import com.slabs.springbootjava.core.ret.ServiceException;
import com.slabs.springbootjava.dao.UserInfoMapper;
import com.slabs.springbootjava.model.UserInfo;
import com.slabs.springbootjava.service.UserInfoService;
import com.slabs.springbootjava.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BingYe
 * @Description: UserInfoService接口实现类
 * @date 2019/03/19 10:41
 */
@Service
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectById(String id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if (userInfo == null) {
            throw new ServiceException("暂无该用户");
        }
        return userInfo;
    }

    @Override
    public List<UserInfo> selectAll(int pageNum, int pageSize) {
        return userInfoMapper.selectAll(pageNum,pageSize);
    }


}