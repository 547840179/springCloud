package xia.wenjie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @描述:
 * @功能:
 * @作者: xiawenjie
 * @时间: 2019/11/5
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"xia.wenjie"})
@ComponentScan("xia.wenjie")

public class DeptConsumer80_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }
}
