package com.slabs.springbootjava.dao;

import com.slabs.springbootjava.core.universal.Mapper;
import com.slabs.springbootjava.model.RolePerm;

import java.util.List;

public interface RolePermMapper extends Mapper<RolePerm> {

    List<String> getPermsByUserId(String userId);
}