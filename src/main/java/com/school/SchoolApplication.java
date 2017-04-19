package com.school;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Course;
import com.school.model.Student;
import com.school.repository.CourseRepository;
import com.school.repository.StudentRepository;

@EntityScan(basePackages = "com.school.model")
@EnableJpaRepositories(basePackages="com.school.repository")
@SpringBootApplication
@RestController
public class SchoolApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SchoolApplication.class);
	
	@Autowired
	private StudentRepository studRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
	
	@RequestMapping("/students/create")
	public Set<Student> studentCreate() {
		HashSet<Student> studSet = new HashSet<>();
		HashSet<Course> courseSet = new HashSet<>();
		
		Student student = new Student("Dimitar");
		studSet.add(student);
		studSet.add(new Student("Nikolay"));
		
		courseSet.add(new Course("INF397b"));
		courseSet.add(new Course("COS397b"));
		
		student.getCourses().addAll(courseSet);
		
		studRepo.save(studSet);
		
		return studSet;
	}
}
