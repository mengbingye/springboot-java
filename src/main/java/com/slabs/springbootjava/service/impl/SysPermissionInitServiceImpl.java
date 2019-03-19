package com.slabs.springbootjava.service.impl;

import com.slabs.springbootjava.dao.SysPermissionInitMapper;
import com.slabs.springbootjava.model.SysPermissionInit;
import com.slabs.springbootjava.service.SysPermissionInitService;
import com.slabs.springbootjava.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BingYe
 * @Description: SysPermissionInitService接口实现类
 * @date 2019/03/19 15:58
 */
@Service
public class SysPermissionInitServiceImpl extends AbstractService<SysPermissionInit> implements SysPermissionInitService {

    @Resource
    private SysPermissionInitMapper sysPermissionInitMapper;

    @Override
    public List<SysPermissionInit> selectAllOrderBySort() {
        return sysPermissionInitMapper.selectAllOrderBySort();
    }
}