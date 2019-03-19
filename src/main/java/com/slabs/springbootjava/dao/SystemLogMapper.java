package com.slabs.springbootjava.dao;

import com.slabs.springbootjava.core.universal.Mapper;
import com.slabs.springbootjava.model.SystemLog;

import java.util.List;

public interface SystemLogMapper extends Mapper<SystemLog> {

    Integer insertByBatch(List<SystemLog> list);
}