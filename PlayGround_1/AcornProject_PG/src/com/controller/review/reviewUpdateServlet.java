package com.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.ReviewDTO;
import com.service.ReviewService;



@WebServlet("/reviewUpdateServlet")
public class reviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public reviewUpdateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		ReviewService rservice = new ReviewService();
		String nextPage = null;

		if (dto != null) {
			//변수 수정 (jsp에서 들어오는 데이터에 따라) //점수 내용. 
			int reviewId = Integer.parseInt(request.getParameter("reviewId"));
			String mbrId = "";
			String gameNo = "";
			String reviewContent = request.getParameter("reviewContent");
			int reviewLiked = 0;
			Double reviewScore = Double.parseDouble(request.getParameter("reviewScore"));
			String reviewDate = "";
			
			
			ReviewDTO rdto = new ReviewDTO(reviewId, mbrId, gameNo, reviewContent, reviewLiked, reviewScore,
					reviewDate);
			int result = rservice.reviewUpdate(rdto);
			if(result==1) {
				System.out.println("Update 성공");
			} else {
				System.out.println("Update 실패");
			}
			
			nextPage = "GameDetailServlet";
		} else {
			nextPage = "LoginServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		response.sendRedirect(nextPage);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}