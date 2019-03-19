package com.slabs.springbootjava.service;

import com.slabs.springbootjava.model.UserInfo;
import com.slabs.springbootjava.core.universal.Service;

import java.util.List;

/**
 * @author BingYe
 * @Description: UserInfoService接口
 * @date 2019/03/19 10:41
 */
public interface UserInfoService extends Service<UserInfo> {
    List<UserInfo> selectAll(int pageNum, int pageSize);
}