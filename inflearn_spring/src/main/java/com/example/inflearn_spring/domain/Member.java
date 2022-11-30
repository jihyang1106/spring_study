package com.example.inflearn_spring.domain;

public class Member {

	private Long id; 	 // 시스템이 자동 생성
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
