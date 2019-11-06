package xia.wenjie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xia.wenjie.jo.Dept;
import xia.wenjie.services.DeptClientService;

import java.util.List;

/**
 * @描述:
 * @功能:
 * @作者: xiawenjie
 * @时间: 2019/11/4
 */
@RestController
public class DeptController_Feign {
    @Autowired
    private DeptClientService deptClientService ;

    @RequestMapping(value = "/consumer/dept/findAll",method = RequestMethod.GET)
    public List<Dept> findAll() {
        return this.deptClientService.findAll();
    }

    @RequestMapping(value = "/consumer/dept/findById/{id}")
    public Dept findById(@PathVariable("id") Long id) {
        return this.deptClientService.findById(id);
    }

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return this.deptClientService.add(dept);
    }
}
