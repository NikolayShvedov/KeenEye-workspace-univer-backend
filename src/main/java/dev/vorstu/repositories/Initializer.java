package dev.vorstu.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.vorstu.dto.Student;

@Component
public class Initializer {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void initial() {
		studentRepository.save(new Student("Shvedov", "IVT-182", "+79009271308"));
		studentRepository.save(new Student("Ivanov", "IVT-183", "+78005553535"));
	}
}
