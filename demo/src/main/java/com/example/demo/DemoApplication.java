package com.example.demo;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import com.example.pojo.Employee;
import com.example.services.EmployeeService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages={"com.example.*"})
@EntityScan(basePackages = "com.example.*")
@EnableJpaRepositories("com.example.repositories")
@RestController
//@EnableScheduling
public class DemoApplication implements CommandLineRunner {

	   @Value("${spring.application.name:demoApp}")
	   public String applicationName;
	   
	   @Autowired
	   EmployeeService emp;
	
	public static void main(String[] args) {
			SpringApplication.run(DemoApplication.class, args);
			Log log  = LogFactory.getLog(DemoApplication.class);
			log.info(":::: "+new Date()+" :::");
	}
	
	@RequestMapping("/")
	public  String Test() {
		return "*** "+applicationName+" started***";
	}

	@Override
	public void run(String... args) throws Exception {
		Employee e = emp.getEmpbyID(6);
		Info i = new Info(10, "orm");
		e.setDept("A");
		e.setName("karthik");
		e.setSalary("100000");
		e.setInfo(i);
		emp.addnewEmp(e);
		
	}
	
	
}
