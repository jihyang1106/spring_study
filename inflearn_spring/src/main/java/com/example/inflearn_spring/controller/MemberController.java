package com.example.inflearn_spring.controller;

import com.example.inflearn_spring.domain.Member;
import com.example.inflearn_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    // new로 많은 객체를 생성하지 않고, 하나 멤버 서비스 객체로 사용
    private final MemberService memberService;

    /*Autowired + 생성자를 이용. 멤버 컨트롤러는 스프링 컨테이너가 뜰 때 생성된다. 그러면 생성자를 호출
    //생성자에 Autowired 키워드가 있으면 멤버서비스를 스프링이 스프링컨테이너에서 멤버서비스를 가져와서 연결한다.
    이게 DI. 멤버 서비스는 스프링컨테이너에서 전달한다.*/
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // memberForm.html 렌더
    @GetMapping("/members/join")
    public String createForm() {
        return "/members/memberForm"; // templates안에 members 폴더가 없으면 오류!
    }

    // 멤버 등록
    @PostMapping("/members/join")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        List<Member> members = memberService.findMembers();
        return "redirect:/"; // 홈으로 이동
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }



}
