package com.slabs.springbootjava.service;

import com.slabs.springbootjava.model.UserRole;
import com.slabs.springbootjava.core.universal.Service;

import java.util.List;

/**
 * @author BingYe
 * @Description: UserRoleService接口
 * @date 2019/03/19 10:41
 */
public interface UserRoleService extends Service<UserRole> {
    List<String> getRolesByUserId(String userId);
}