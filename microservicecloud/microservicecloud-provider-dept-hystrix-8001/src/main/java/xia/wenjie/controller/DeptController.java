package xia.wenjie.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import xia.wenjie.jo.Dept;
import xia.wenjie.service.Deptservice;

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
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept findById(@PathVariable("id") Long id) {


        Dept dept = deptservice.findById(id);
        if (null == dept) {
            throw new RuntimeException("该id" + id + "没有对应的信息");
        }
        return dept;
    }


    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        Dept errorObj = new Dept();

        errorObj.setDeptno(id);
        errorObj.setDname("该id" + id + "没有对应的信息，null--@HystrixCommand");
        errorObj.setDb_source("no this database in MySQL");
        return errorObj;
    }


    @RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
    public List<Dept> findall() {
        return deptservice.findAll();
    }
}
