package xia.wenjie.services;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import xia.wenjie.jo.Dept;

import java.util.List;

/**
 * @描述:
 * @功能:
 * @作者: xiawenjie
 * @时间: 2019/11/6
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept findById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }
        };
    }
}
