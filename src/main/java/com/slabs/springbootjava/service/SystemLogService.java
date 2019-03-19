package com.slabs.springbootjava.service;

import com.slabs.springbootjava.model.SystemLog;
import com.slabs.springbootjava.core.universal.Service;

import java.util.List;

/**
 * @author BingYe
 * @Description: SystemLogService接口
 * @date 2019/03/19 10:41
 */
public interface SystemLogService extends Service<SystemLog> {
    Integer insertByBatch(List<SystemLog> list);

}