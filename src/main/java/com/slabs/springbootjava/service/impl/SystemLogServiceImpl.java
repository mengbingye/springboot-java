package com.slabs.springbootjava.service.impl;

import com.slabs.springbootjava.dao.SystemLogMapper;
import com.slabs.springbootjava.model.SystemLog;
import com.slabs.springbootjava.service.SystemLogService;
import com.slabs.springbootjava.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author BingYe
 * @Description: SystemLogService接口实现类
 * @date 2019/03/18 16:58
 */
@Service
public class SystemLogServiceImpl extends AbstractService<SystemLog> implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

}