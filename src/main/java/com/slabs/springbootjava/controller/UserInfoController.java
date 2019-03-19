package com.slabs.springbootjava.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
@Api(tags = {"用户操作接口"}, description = "userInfoController")
public class UserInfoController {

    @Resource
    private IUserInfoService userInfoService;


    @GetMapping
    public String hello() {
        return "hello  Springboot";
    }


    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "id", value = "用户Id", required = true,
                    dataType = "String", paramType = "query")}
    )
    @PostMapping
    public RetResult<UserInfo> selectById(@RequestParam String id) {
        System.out.println(id);
        UserInfo userInfo = this.userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }

    @PostMapping("/testException")
    public RetResult<UserInfo> testException(String id) {
        List a = null;
        a.size();
        UserInfo userInfo = userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }


    @ApiOperation(value = "查询用户", notes = "分页查询用户所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码",
                    dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数",
                    dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selectAll")
    public RetResult<PageInfo<UserInfo>> selectAll(@RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserInfo> userInfos = this.userInfoService.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfos);
        return RetResponse.makeOKRsp(pageInfo);
    }
}
