package com.slabs.springbootjava.service;

import com.slabs.springbootjava.model.SysPermissionInit;
import com.slabs.springbootjava.core.universal.Service;

import java.util.List;

/**
 * @author BingYe
 * @Description: SysPermissionInitService接口
 * @date 2019/03/19 15:58
 */
public interface SysPermissionInitService extends Service<SysPermissionInit> {

    List<SysPermissionInit> selectAllOrderBySort();
}