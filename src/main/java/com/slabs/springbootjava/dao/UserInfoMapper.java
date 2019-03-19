package com.slabs.springbootjava.dao;

import com.slabs.springbootjava.core.universal.Mapper;
import com.slabs.springbootjava.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper extends Mapper<UserInfo> {


    List<UserInfo> selectAll(@Param("pageNumKey") int pageNum,
                             @Param("pageSizeKey") int pageSize);
}