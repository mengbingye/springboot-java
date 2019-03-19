package com.slabs.springbootjava.service;

import java.util.Map;

/**
 * shiro 动态更新权限
 * @create: 2019/03/19 16:05
 */

public interface ShiroService {

    Map<String,String> loadFilterChainDefinitions();

    /**
     * 动态修改权限
     */
    void updatePermission();
}
