package cn.csms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mp
@MapperScan("cn.csms.mapper")
public class CsmsSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsmsSpringbootApplication.class, args);
        System.out.println("启动成功");
    }

}
