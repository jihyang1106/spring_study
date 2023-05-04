package com.example.inflearn_spring.domain;

import javax.persistence.*;

@Entity
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 	 // 시스템이 자동 생성

	@Column(name="name")
	private String name; // Member가 정하는 것
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
