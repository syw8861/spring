package com.yedam.app.member.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.service.MemberService;

@Controller
public class MemberController {
	//requestMapping에 적어주는게 주소에서 찾아갈 곳
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/memberListAll")
	public String memberList(Model model, HttpServletRequest request, HttpSession session) {
		//request.setAttribute 처럼 쓰는게 model
		
		//회원조회
		model.addAttribute("list", memberService.selectAll());
		return "/member/memberAll";
	}
	
	//단건조회
	@RequestMapping("/memberSelect")
	public String memberSelect(@RequestParam(name = "id", required = false , defaultValue = "aabb")
								String mid, Model model, HttpServletRequest request) {
		//파라미터 이름이 woew인 애를 받아서 string 타입의 id에 담아라 required를 false로 지정하면 파라미터가 안넘어와도 된다는말
		MemberVO vo = new MemberVO();
//		String mid = request.getParameter("id");
		if(mid != null) {
			mid="aabb";
		}
//		vo.setId(mid);
		model.addAttribute("member",memberService.selectOne(vo)); //멤버속성으로 넘긴다
		return "member/memberSelect";
	}
	
	
	//등록페이지
	@RequestMapping(method =RequestMethod.GET ,value= "/memberInsert")
	public String memberInsertForm() {
		return "member/memberInsert";
	}
	
	
	
	@RequestMapping(value="/memberInsert", method=RequestMethod.POST)
	public String memberInsert(MemberVO memberVO) {
//		MemberVO vo = new ~~
//				vo.set   이런식으로 했었는데 여기선 걍 메소드에 매게값으로 MemberVO넣어주면 다 됨
		System.out.println(memberVO);
		memberService.insert(memberVO);
		return "redirect:/memberListAll";
		//default가 forward고 redirect넣어주면 저거 됨
	}
	
	
	
	//경로명에 변수가 포함 (PathVariable사용)
	@RequestMapping("/userSelectPath/{id}")
	public String userSelectPath(Model model, @PathVariable String id) { //REquestMapping에 path에 마지막id에 값이 패스에 담기고
		MemberVO vo = new MemberVO();
		vo.setId(id);
		model.addAttribute("member", memberService.selectOne(vo));
		return "member/memberSelect";
	}
	
	
	
	//파라미터를 map에 담아서 보기
	@RequestMapping("/userSelectMap")
	public String userSelectMap(@RequestParam Map map) {
		System.out.println(map);
		return "";
		
	}
	
	@RequestMapping("/memberListAjax")
	@ResponseBody
	public List<MemberVO> memberListAjax() {
		
		//회원조회
		return memberService.selectAll();
	}
	
	
	@RequestMapping("/memberSelectAjax")
	@ResponseBody
	public MemberVO memberSelectAjax(MemberVO memberVO) {
		//회원조회
		return memberService.selectOne(memberVO);
	}
	
	
}
