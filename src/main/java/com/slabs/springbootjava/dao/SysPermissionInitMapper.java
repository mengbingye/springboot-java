package com.slabs.springbootjava.dao;

import com.slabs.springbootjava.core.universal.Mapper;
import com.slabs.springbootjava.model.SysPermissionInit;

import java.util.List;

public interface SysPermissionInitMapper extends Mapper<SysPermissionInit> {

    List<SysPermissionInit> selectAllOrderBySort();
}