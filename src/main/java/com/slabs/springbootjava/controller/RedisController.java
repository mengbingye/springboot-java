package com.slabs.springbootjava.controller;

import com.slabs.springbootjava.core.ret.RetResponse;
import com.slabs.springbootjava.core.ret.RetResult;
import com.slabs.springbootjava.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @create: 2019/03/18 17:29
 */

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisService redisService;

    @PostMapping
    public RetResult<String> setRedis(String name) {
        redisService.set("name",name);
        return RetResponse.makeOKRsp(name);
    }

    @GetMapping
    public RetResult<String> getRedis() {
        String name = redisService.get("name");
        return RetResponse.makeOKRsp(name);
    }


}
