package xia.wenjie.jo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @描述:
 * @功能:
 * @作者: xiawenjie
 * @时间: 2019/10/19
 */
//@SuppressWarnings("serial")//忽略 警告的注解
//@AllArgsConstructor //有参构造
@NoArgsConstructor  //空参构造
@Data    //get/set/toString方法
@Accessors(chain = true) //链式
public class Dept implements Serializable {
    private Long deptno; // 主键
    private String dname; // 部门名称
    private String db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

/*
    public Dept(String dname) {
        super();
        this.dname = dname;
    }*/

}
