package com.slabs.springbootjava.controller;

import com.slabs.springbootjava.core.aop.AnnotationLog;
import com.slabs.springbootjava.core.ret.RetResult;
import com.slabs.springbootjava.core.ret.RetResponse;
import com.slabs.springbootjava.core.ret.ServiceException;
import com.slabs.springbootjava.core.utils.ApplicationUtils;
import com.slabs.springbootjava.model.UserInfo;
import com.slabs.springbootjava.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BingYe
 * @Description: UserInfoController类
 * @date 2019/03/19 10:41
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;


    @PostMapping("/login")
    public RetResult<UserInfo> login(String userName, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        //登录
        try {
            currentUser.login(new UsernamePasswordToken(userName, password));
        } catch (IncorrectCredentialsException i) {
            throw new ServiceException("密码输入错误");
        }
        //从session取出用户信息
        UserInfo user = (UserInfo) currentUser.getPrincipal();
        return RetResponse.makeOKRsp(user);
    }


    @PostMapping("/insert")
    public RetResult
            <Integer> insert(UserInfo userInfo) throws Exception {
        userInfo.setId(ApplicationUtils.getUUID());
        Integer state = userInfoService.insert(userInfo);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/deleteById")
    public RetResult
            <Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = userInfoService.deleteById(id);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public RetResult
            <Integer> update(UserInfo userInfo) throws Exception {
        Integer state = userInfoService.update(userInfo);
        return RetResponse.makeOKRsp(state);
    }

    @GetMapping("/selectById")
    @AnnotationLog(remark = "查询")
    public RetResult<UserInfo> selectById(@RequestParam String id) throws Exception {
        UserInfo userInfo = userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }

    /**
     * @param page 页码
     * @param size 每页条数
     * @Description: 分页查询
     * @Reutrn RetResult
     * <PageInfo
     * <UserInfo>>
     */
    @GetMapping("/selectAll")
    public RetResult
            <PageInfo
                    <UserInfo>> list(@RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<UserInfo> list = userInfoService.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
}