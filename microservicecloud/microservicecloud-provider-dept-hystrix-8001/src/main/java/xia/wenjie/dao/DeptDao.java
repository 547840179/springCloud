package xia.wenjie.dao;

import org.apache.ibatis.annotations.Mapper;
import xia.wenjie.jo.Dept;

import java.util.List;


/**
 * @描述:
 * @功能:
 * @作者: xiawenjies
 * @时间: 2019/11/5
 */
@Mapper
public interface DeptDao {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
