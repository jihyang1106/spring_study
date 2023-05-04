package com.example.inflearn_spring.controller;

// 스프링이 form으로 받은 name의 값을 setName 시킨다.
public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
