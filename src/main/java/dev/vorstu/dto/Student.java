package dev.vorstu.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simple domain object Student.
 */
@Entity
@Table(name="students")
public class Student {

	public Student() {}
	
	public Student(String fio, String group, String phoneNumber) {
		this.fio = fio;
		this.group = group;
		this.phoneNumber = phoneNumber;
	}
	
	public Student(Long id, String fio, String group, String phoneNumber) {
		this(fio, group, phoneNumber);
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String fio;
	
	@Column(name="group_of_students")
	private String group;
	
	private String phoneNumber;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
