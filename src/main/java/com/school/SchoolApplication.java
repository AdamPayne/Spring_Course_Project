package com.school;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Course;
import com.school.model.Professor;
import com.school.model.Student;
import com.school.service.SchoolService;

@EntityScan(basePackages = "com.school.model")
@EnableJpaRepositories(basePackages="com.school.repository")
@SpringBootApplication
@RestController
public class SchoolApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SchoolApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
}
