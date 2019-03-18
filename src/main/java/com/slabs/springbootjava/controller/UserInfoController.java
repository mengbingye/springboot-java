package com.slabs.springbootjava.controller;

import com.slabs.springbootjava.core.ret.RetResponse;
import com.slabs.springbootjava.core.ret.RetResult;
import com.slabs.springbootjava.model.UserInfo;
import com.slabs.springbootjava.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @create: 2019/03/18 11:00
 */
@RestController
@RequestMapping("/users")
@Api(tags = {"用户操作接口"},description = "userInfoController")
public class UserInfoController {

    @Resource
    private IUserInfoService userInfoService;


    @GetMapping
    public String hello() {
        return "hello  Springboot";
    }


    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "id",value = "用户Id",required = true,
            dataType = "Integer",paramType = "query")}
    )
    @PostMapping
    public RetResult<UserInfo> selectById(@RequestParam Integer id){
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
