package com.slabs.springbootjava.service.impl;

import com.slabs.springbootjava.dao.SysRoleMapper;
import com.slabs.springbootjava.model.SysRole;
import com.slabs.springbootjava.service.SysRoleService;
import com.slabs.springbootjava.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author BingYe
 * @Description: SysRoleService接口实现类
 * @date 2019/03/19 10:41
 */
@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

}