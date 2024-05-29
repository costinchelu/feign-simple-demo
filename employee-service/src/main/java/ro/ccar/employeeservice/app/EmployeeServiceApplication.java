package ro.ccar.employeeservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "ro.ccar.employeeservice")
@EnableJpaRepositories(basePackages = "ro.ccar.employeeservice")
@EntityScan(basePackages = "ro.ccar.employeeservice.entity")
@EnableFeignClients(basePackages = "ro.ccar.employeeservice.client")
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}
