package com.slabs.springbootjava.dao;

import com.slabs.springbootjava.core.universal.Mapper;
import com.slabs.springbootjava.model.UserRole;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {


    List<String> getRolesByUserId(String userId);
}