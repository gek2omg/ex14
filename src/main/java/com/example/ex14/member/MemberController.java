package com.example.ex14.member;

import com.example.ex14.member.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {

    @GetMapping("/memberForm")
    public String memberForm() {

        return "memberForm";
    }

    @PostMapping("/api/member")
    @ResponseBody
    public Map<String, String> memberFormProc(MemberDto memberDto) {
        Map<String, String> results = new HashMap<>();

        System.out.println(memberDto.toString());

        String name = memberDto.getName();

        if(name.equals("abc")) {
            results.put("message", "SUCCESS");
            results.put("content", "입력값이 성공적으로 저장 되었습니다.");
        } else {
            results.put("message", "FALSE");
            results.put("content", "처리중 오류가 발생했습니다.");
        }

        return results;
    }
}
