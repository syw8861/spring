package com.yedam.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	//requestMapping에 적어주는게 주소에서 찾아갈 곳
	
	@Autowired
	DAO dao;
	
	@RequestMapping("/memberListAll")
	public String memberList(Model model) {
		//request.setAttribute 처럼 쓰는게 model
		model.addAttribute("list", dao.selectAll(null));
		return "/member/memberAll";
	}
	
	@RequestMapping("/memberInsert")
	public String memberInsert(MemberVO vo) {
//		MemberVO vo = new ~~
//				vo.set   이런식으로 했었는데 여기선 걍 메소드에 매게값으로 MemberVO넣어주면 다 됨
		System.out.println(vo);
		return "member/memberList";
		//default가 forward고 redirect넣어주면 저거 됨
	}
}
