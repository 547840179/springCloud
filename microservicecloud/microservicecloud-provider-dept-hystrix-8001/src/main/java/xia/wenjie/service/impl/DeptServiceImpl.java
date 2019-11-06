package xia.wenjie.service.impl;

import org.springframework.stereotype.Service;

import xia.wenjie.dao.DeptDao;
import xia.wenjie.jo.Dept;
import xia.wenjie.service.Deptservice;

import javax.annotation.Resource;
import java.util.List;

/**
 * @描述:
 * @功能:
 * @作者: xiawenjie
 * @时间: 2019/10/19
 */
@Service
public class DeptServiceImpl implements Deptservice {
 //   @Autowired
    @Resource
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        //System.out.println(deptDao.findAll()+"deptDao.findAll()");
        return deptDao.findAll();
    }
}
