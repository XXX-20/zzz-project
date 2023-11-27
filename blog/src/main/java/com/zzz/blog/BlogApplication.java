package com.zzz.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.zzz.blog.mapper"})
public class BlogApplication {

	public static void main(String[] args) {
		// 返回IOC容器
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(BlogApplication.class, args);

		// 查看IOC容器中的Bean对应的name
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

}
