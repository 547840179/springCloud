package xia.wenjie.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xia.wenjie.jo.Dept;

import java.util.List;

/**
 * @描述:
 * @功能:
 * @作者: xiawenjie
 * @时间: 2019/10/19
 */
@Mapper
public interface DeptDao {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
