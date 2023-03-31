package juice.test;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("juice.test.**.mapper")
public class JuiceTestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuiceTestDemoApplication.class, args);
    }

}
