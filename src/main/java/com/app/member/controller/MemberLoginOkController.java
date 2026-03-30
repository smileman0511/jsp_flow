package com.app.member.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.Action;
import com.app.Result;
import com.app.dao.MemberDAO;
import com.app.vo.MemberVO;

public class MemberLoginOkController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		
//		서버 저장소
//		request를 통해 session 객체를 가져올 수 있다.
//		서버에서 모두 사용할 수 있는 공용 저장소이다.
		HttpSession session = req.getSession();
		
		String memberEmail = req.getParameter("memberEmail");
		String memberPassword = req.getParameter("memberPassword");
		
		memberVO.setMemberEmail(memberEmail);
		memberVO.setMemberPassword(req.getParameter("memberPassword"));
		
//		이메일 여부
		if(memberDAO.existsByMemberEmail(memberEmail) == 0) {
			result.setRedirect(true);
			result.setPath("/flow/login.member?flag=memberEmail");
			return result;
		}
		
//		비밀번호 틀린 여부
		Optional<MemberVO> foundMember = memberDAO.findByMemberEmailAndMemberPassword(memberVO);
		MemberVO loginMember = null;
		
//			비밀번호가 틀렸다면
		if(!foundMember.isPresent()) {
			result.setRedirect(true);
			result.setPath("/flow/login.member?flag=memberPassword");
			return result;
		}
//			비밀번호까지 일치한다면
		loginMember = foundMember.get();
		result.setRedirect(true);
		result.setPath("/flow/my-page.member");
			
//			회원정보를 서버 저장소에 저장
		session.setAttribute("memberEmail", loginMember.getMemberEmail());
		
		return result;
	}

}
