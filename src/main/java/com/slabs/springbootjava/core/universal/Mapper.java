package com.slabs.springbootjava.core.universal;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 定制版MyBatis Mapper插件接口
 * @create: 2019/03/18 15:32
 */
public interface Mapper<T> extends BaseMapper<T>,ConditionMapper<T>,IdsMapper<T>,InsertListMapper<T> {
}
