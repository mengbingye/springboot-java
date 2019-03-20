package com.slabs.springbootjava.controller;

import com.slabs.springbootjava.core.ret.RetResult;
import com.slabs.springbootjava.core.ret.RetResponse;
import com.slabs.springbootjava.core.utils.ApplicationUtils;
import com.slabs.springbootjava.model.SysPerm;
import com.slabs.springbootjava.service.SysPermService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BingYe
 * @Description: SysPermController类
 * @date 2019/03/19 10:41
 */
@RestController
@RequestMapping("/sysPerm")
public class SysPermController {

    @Resource
    private SysPermService sysPermService;

    @PostMapping("/insert")
    public RetResult<Integer> insert(SysPerm sysPerm) throws Exception {
        sysPerm.setId(ApplicationUtils.getUUID());
        Integer state = sysPermService.insert(sysPerm);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/deleteById")
    public RetResult<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = sysPermService.deleteById(id);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public RetResult<Integer> update(SysPerm sysPerm) throws Exception {
        Integer state = sysPermService.update(sysPerm);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public RetResult<SysPerm> selectById(@RequestParam String id) throws Exception {
        SysPerm sysPerm = sysPermService.selectById(id);
        return RetResponse.makeOKRsp(sysPerm);
    }

    /**
     * @param page 页码
     * @param size 每页条数
     * @Description: 分页查询
     * @Reutrn RetResult
     * <PageInfo
     * <SysPerm>>
     */
    @PostMapping("/list")
    public RetResult<PageInfo<SysPerm>> list(@RequestParam(defaultValue = "0") Integer page,
                                             @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<SysPerm> list = sysPermService.selectAll();
        PageInfo<SysPerm> pageInfo = new PageInfo<SysPerm>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
}