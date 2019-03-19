package com.slabs.springbootjava.service.impl;

import com.slabs.springbootjava.dao.UserRoleMapper;
import com.slabs.springbootjava.model.UserRole;
import com.slabs.springbootjava.service.UserRoleService;
import com.slabs.springbootjava.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BingYe
 * @Description: UserRoleService接口实现类
 * @date 2019/03/19 10:41
 */
@Service
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public List<String> getRolesByUserId(String userId) {
        return this.userRoleMapper.getRolesByUserId(userId);
    }
}