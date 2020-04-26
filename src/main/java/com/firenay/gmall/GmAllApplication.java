package com.firenay.gmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.firenay.gmall.mapper")
@SpringBootApplication
public class GmAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmAllApplication.class, args);
	}

}
