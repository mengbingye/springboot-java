package com.slabs.springbootjava.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.slabs.springbootjava.core.ret.ServiceException;
import com.slabs.springbootjava.dao.UserInfoMapper;
import com.slabs.springbootjava.model.UserInfo;
import com.slabs.springbootjava.service.IUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @create: 2019/03/18 10:58
 */
@Service
public class UserInfoService implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectById(Integer id) {
        UserInfo userInfo = this.userInfoMapper.selectById(id);
        if (ObjectUtils.isEmpty(userInfo)) {
            throw new ServiceException("暂无该用户");
        }
        return userInfo;

    }

    @Override
    public PageInfo<UserInfo> selectAll(Integer page, Integer size) {
        //开启分页查询，写在查询语句上方
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
        PageHelper.startPage(page, size);
        List<UserInfo> userInfoList = userInfoMapper.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        return pageInfo;
    }
}
