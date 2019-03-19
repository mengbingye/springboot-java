package com.slabs.springbootjava.service.impl;

import com.slabs.springbootjava.dao.SysPermMapper;
import com.slabs.springbootjava.model.SysPerm;
import com.slabs.springbootjava.service.SysPermService;
import com.slabs.springbootjava.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author BingYe
 * @Description: SysPermService接口实现类
 * @date 2019/03/19 10:41
 */
@Service
public class SysPermServiceImpl extends AbstractService<SysPerm> implements SysPermService {

    @Resource
    private SysPermMapper sysPermMapper;

}