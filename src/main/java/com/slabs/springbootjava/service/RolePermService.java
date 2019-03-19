package com.slabs.springbootjava.service;

import com.slabs.springbootjava.model.RolePerm;
import com.slabs.springbootjava.core.universal.Service;

import java.util.List;

/**
 * @author BingYe
 * @Description: RolePermService接口
 * @date 2019/03/19 10:41
 */
public interface RolePermService extends Service<RolePerm> {
    List<String> getPermsByUserId(String userId);
}