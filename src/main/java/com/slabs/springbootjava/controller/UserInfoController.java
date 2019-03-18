package com.slabs.springbootjava.controller;

import com.slabs.springbootjava.core.ret.RetResponse;
import com.slabs.springbootjava.core.ret.RetResult;
import com.slabs.springbootjava.model.UserInfo;
import com.slabs.springbootjava.service.IUserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @create: 2019/03/18 11:00
 */
@RestController
@RequestMapping("/users")
public class UserInfoController {

    @Resource
    private IUserInfoService userInfoService;


    @GetMapping
    public String hello() {
        return "hello  Springboot";
    }


    @PostMapping
    public RetResult<UserInfo> selectById(Integer id){
        UserInfo userInfo = this.userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }

    @PostMapping("/testException")
    public RetResult<UserInfo> testException(Integer id){
        List a = null;
        a.size();
        UserInfo userInfo = userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }


}
