package xia.wenjie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xia.wenjie.jo.Dept;
import xia.wenjie.service.Deptservice;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @描述:
 * @功能:
 * @作者: xiawenjie
 * @时间: 2019/10/19
 */

@RestController
public class DeptController {
    @Autowired
    private Deptservice deptservice;

    //注册发现
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("===============" + list);
        List<ServiceInstance> instances = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.client;
    }


    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptservice.addDept(dept);
    }

    @RequestMapping(value = "/dept/findById/{id}", method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Long id) {
        return deptservice.findById(id);
    }

    @RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
    public List<Dept> findall() {
        return deptservice.findAll();
    }
}
