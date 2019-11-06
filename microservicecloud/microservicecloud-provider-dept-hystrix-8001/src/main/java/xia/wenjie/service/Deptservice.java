package xia.wenjie.service;

import xia.wenjie.jo.Dept;

import java.util.List;

/**
 * @描述:
 * @功能:
 * @作者: xiawenjie
 * @时间: 2019/10/19
 */
public interface Deptservice {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
