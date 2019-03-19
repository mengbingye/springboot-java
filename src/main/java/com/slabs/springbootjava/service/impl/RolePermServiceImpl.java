package com.slabs.springbootjava.service.impl;

import com.slabs.springbootjava.dao.RolePermMapper;
import com.slabs.springbootjava.model.RolePerm;
import com.slabs.springbootjava.service.RolePermService;
import com.slabs.springbootjava.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BingYe
 * @Description: RolePermService接口实现类
 * @date 2019/03/19 10:41
 */
@Service
public class RolePermServiceImpl extends AbstractService<RolePerm> implements RolePermService {

    @Resource
    private RolePermMapper rolePermMapper;

    @Override
    public List<String> getPermsByUserId(String userId) {
        return this.rolePermMapper.getPermsByUserId(userId);
    }
}