package com.exam.examPortalServer;

import com.exam.examPortalServer.repository.IRoleRepository;
import com.exam.examPortalServer.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamPortalServerApplication {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IRoleRepository roleRepository;
	public static void main(String[] args) {


		SpringApplication.run(ExamPortalServerApplication.class, args);
		System.out.println("Exam Portal Application Started...");
	}


}
